package org.daimhim.network.clouddata;


import org.daimhim.network.config.Config;

import java.io.File;

import okhttp3.Cache;

/**
 * 项目名称：com.example.commonutils.clouddata
 * 项目版本：usedlibrary
 * 创建人：Daimhim
 * 创建时间：2017/8/3 14:34
 * 修改人：Daimhim
 * 修改时间：2017/8/3 14:34
 * 类描述：
 * 修改备注：
 */

public class HttpCache {

    public static Cache getCache() {
        return new Cache(new File(Config.application.getCacheDir().getAbsolutePath() + File.separator + "data/NetCache"),
                Config.HTTP_RESPONSE_DISK_CACHE_MAX_SIZE);
    }
}
