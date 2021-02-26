package com.tracejp.yuka.sqlDataTest;

import com.tracejp.yuka.utils.Util;
import org.junit.Test;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/*********************************
 * @author traceJP
 *********************************/
public class AddMusicResourcesTable {

    // 本地音乐资源url
    private final String localMusicResourcesURL = "/YuKaMusicCity/main/fileSQL/audio/";
    // 本地音乐图片url
    private final String localMusicImgURL = "../../sqlresources/musicImg/";

    @Test
    public void start() throws SQLException {
        Connection conn = JdbcUtil.getConnection();
        String sql = "INSERT INTO `music_resources`(music_name, music_img_url, music_url, music_author) " +
                "VALUES(?,?,?,?) ";
        String[][] result = getFileName();
        for(int i = 0;i < result.length;i++) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, result[i][1]);
            // 图片
            ps.setString(2, null);
            ps.setString(3, result[i][2]);
            ps.setString(4, result[i][0]);
            ps.execute();
        }
        System.out.println("测试数据已添加");
    }

    private String[][] getFileName() {
        File file = new File("D:\\CloudMusic\\");
        String[] fileList = file.list();
        // 结果返回集
        String rts[][] = new String[fileList.length][3];
        int i = 0;
        int j = 0;
        int k = 0;
        for (String fileName : fileList) {
            // 拆分
            String[] a = fileName.split(" - ");
            // 0 作者
            rts[i++][0] = a[0];
            // 1 歌名
            rts[j++][1] = a[1].replace(".mp3", "");
            // 获取一个16位随机数
            String rand = Util.getRandomString(16);
            // 修改歌曲名为这个16位数
            File file1 = new File("D:\\CloudMusic\\" + fileName);
            file1.renameTo(new File("D:\\CloudMusic\\" + rand + ".mp3"));
            // 2 歌曲url
            rts[k++][2] = localMusicResourcesURL + rand + ".mp3";
        }
        return rts;
    }

}
