package com.tracejp.yuka.service.pagebuilder;

import com.tracejp.yuka.dao.HomeViewPageMapper;
import com.tracejp.yuka.model.bo.HomeListenToSongsBO;
import com.tracejp.yuka.model.bo.HomeUserInfomationBO;
import com.tracejp.yuka.model.bo.HomeUserLevelBO;
import com.tracejp.yuka.model.dao.HomeListenToSongsDAO;
import com.tracejp.yuka.model.dao.HomeUserInformationDAO;
import com.tracejp.yuka.model.dao.HomeUserLevelDAO;
import com.tracejp.yuka.service.level.UserLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;

import java.util.Date;
import java.util.List;

/*********************************
 * @author traceJP
 *********************************/
@Service
@RequestScope
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
                null,
                infoDAO.getUserIntroduction()
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
        int overLogin = levelService.overLoginConverter(
                levelDAO.getLevelNumber(),
                levelDAO.getUserLoginDays()
        );
        int overSong = levelService.overSongNumberConverter(
                levelDAO.getLevelNumber(),
                levelDAO.getUserSongNumber()
        );
        float percentageLogin = levelService.percentageLoginConverter(
                levelDAO.getLevelNumber(),
                levelDAO.getUserLoginDays()
        );
        float percentageSong = levelService.percentageSongNumberConverter(
                levelDAO.getLevelNumber(),
                levelDAO.getUserSongNumber()
        );
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
        if(listDAO == null) {
            return null;
        }
        // 查询每首歌的所有听歌次数总和
        for (HomeListenToSongsDAO item : listDAO) {
            Integer sum = viewPage.selectSongSum(item.getId());
            item.setBroadcastNumberTimesTotal(sum);
        }
        // 计算百分比属性并封装到BO中
        HomeListenToSongsBO[] listBO = new HomeListenToSongsBO[listDAO.size()];
        for(int i = 0;i < listBO.length;i++) {
            listBO[i] = new HomeListenToSongsBO();
        }
        int i = 0;
        for(HomeListenToSongsDAO item : listDAO) {
            listBO[i].setId(item.getId());
            listBO[i].setMusicName(item.getMusicName());
            listBO[i].setMusicAuthor(item.getMusicAuthor());
            listBO[i].setBroadcastNumberTimes(item.getBroadcastNumberTimes());
            float percentage = (float)item.getBroadcastNumberTimes() / (float)item.getBroadcastNumberTimesTotal();
            listBO[i].setMusicNumberPercentage(percentage);
            i++;
        }
        return listBO;
    }

    @Override
    protected void userUpgrade() {
        HomeUserLevelDAO levelDAO = viewPage.selectUserLevel(userUid);
        levelService.userUpgrade(
                userUid,
                levelDAO.getLevelNumber(),
                levelDAO.getUserSongNumber(),
                levelDAO.getUserLoginDays()
                );
    }

}
