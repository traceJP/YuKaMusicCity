package com.tracejp.yuka.service.base;

import com.tracejp.yuka.dao.HomeViewPageMapper;
import com.tracejp.yuka.model.bo.HomeListenToSongsBO;
import com.tracejp.yuka.model.bo.HomeUserInfomationBO;
import com.tracejp.yuka.model.bo.HomeUserLevelBO;
import com.tracejp.yuka.model.dao.HomeListenToSongsDAO;
import com.tracejp.yuka.model.dao.HomeUserInformationDAO;
import com.tracejp.yuka.model.dao.HomeUserLevelDAO;
import com.tracejp.yuka.service.HomePageBuilder;
import com.tracejp.yuka.service.UserLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.ListIterator;

/*********************************
 * @author traceJP
 *********************************/
@Service
public class HomePageServiceBuilder extends HomePageBuilder {

    @Autowired
    private HomeViewPageMapper viewPage;

    @Autowired
    private UserLevelService levelService;

    @Override
    protected HomeUserInfomationBO personalInformation() {
        HomeUserInformationDAO infoDAO = viewPage.selectUserInfo(userUid);
        HomeUserInfomationBO infoBO = new HomeUserInfomationBO(
                infoDAO.getUserId(),
                infoDAO.getUserAvatarImgUrl(),
                infoDAO.getUserName(),
                infoDAO.getUserArea(),
                infoDAO.getUserSex(),
                null
        );
        Date birthday = infoDAO.getUserBirthday();
        if(birthday == null) {
            return infoBO;
        }
        // 运算时间得到年龄
        Date currentTime = new Date();
        long nowTime = currentTime.getTime();
        long birthdayTime = birthday.getTime();
        int userAge =(int) ((nowTime - birthdayTime) / 86400000);
        infoBO.setUserAge(userAge);
        return infoBO;
    }

    @Override
    protected HomeUserLevelBO myGrade() {
        HomeUserLevelDAO levelDAO = viewPage.selectUserLevel(userUid);
        int overLogin = levelService.overLoginConverter(levelDAO.getLevelNumber(), levelDAO.getUserLoginDays());
        int overSong = levelService.overSongNumberConverter(levelDAO.getLevelNumber(), levelDAO.getUserSongNumber());
        float percentageLogin = levelService.percentageLoginConverter(levelDAO.getLevelNumber(), levelDAO.getUserLoginDays());
        float percentageSong = levelService.percentageSongNumberConverter(levelDAO.getLevelNumber(), levelDAO.getUserSongNumber());
        int countMusic = levelDAO.getUserSongNumber();
        // 将DAO对象总值替换成剩余值，并延续给BO对象使用
        levelDAO.setUserLoginDays(overLogin);
        levelDAO.setUserSongNumber(overSong);
        return new HomeUserLevelBO(
                percentageLogin,
                percentageSong,
                levelDAO,
                countMusic
        );
    }

    @Override
    protected HomeListenToSongsBO[] listenToSongsRank() {
        List<HomeListenToSongsDAO> listDAO = viewPage.selectUserSongsRank(userUid, RANK_RETURN_COUNT);
        // 真实元素返回个数
        int realResultCount = listDAO.size();
        ListIterator<HomeListenToSongsDAO> iterator = listDAO.listIterator();
        HomeListenToSongsBO[] listBO = new HomeListenToSongsBO[realResultCount];
        for(int i = 0; i < realResultCount; i++) {
            HomeListenToSongsDAO element = iterator.next();
            listBO[i].setId(element.getId());
            listBO[i].setMusicName(element.getMusicName());
            listBO[i].setMusicAuthor(element.getMusicAuthor());
            listBO[i].setBroadcastNumberTimes(element.getBroadcastNumberTimes());
            float percentage = (float)element.getBroadcastNumberTimes() / (float)element.getBroadcastNumberTimesTotal();
            listBO[i].setMusicNumberPercentage(percentage);
        }
        return listBO;
    }

}
