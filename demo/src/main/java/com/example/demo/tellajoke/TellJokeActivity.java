package com.example.demo.tellajoke;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.demo.mvp.MVPBaseActivity;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * 项目名称：com.example.demo.tellajoke
 * 项目版本：usedlibrary
 * 创建人：Daimhim
 * 创建时间：2017/8/4 9:27
 * 修改人：Daimhim
 * 修改时间：2017/8/4 9:27
 * 类描述：
 * 修改备注：
 */

public class TellJokeActivity extends MVPBaseActivity<TellJokeContract.Presenter,TellJokeModuleMVP> {
    TellJokeFragmentMVP mTellJokeFragment;
    @Override
    protected void setPresenterAndModule() {
        module = new TellJokeModuleMVP();
        mTellJokeFragment = new TellJokeFragmentMVP();
        presenter = new TellJokePresenterMVP(mTellJokeFragment,module);
        mTellJokeFragment.setPresenterAndModule(presenter,module);
    }

    public void setTvDate(final TextView tvDate){
        Observable.just(new Date())
                .map(new Function<Date, Date>() {
                    @Override
                    public Date apply(Date date) throws Exception {
                        try {
                            URL url=new URL("http://www.baidu.com");//取得资源对象
                            URLConnection uc=url.openConnection();//生成连接对象
                            uc.connect(); //发出连接
                            long ld=uc.getDate(); //取得网站日期时间
                            date.setTime(ld);
                            return date;
                        } catch (MalformedURLException e) {
                            e.printStackTrace();
                        }// 取得资源对象
                        catch (IOException e) {
                        }
                        return date;
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Date>() {
                    @Override
                    public void accept(Date date) throws Exception {
                        tvDate.setText(date.getDate()+"日"+date.getHours()+"时"+date.getMinutes()+"分"+date.getSeconds()+"秒");
                        System.out.print(date.getDate()+"日"+date.getHours()+"时"+date.getMinutes()+"分"+date.getSeconds()+"秒");
                    }
                });
    }

    @Override
    protected void onSetContentView() {
        addFragmentToActivity(mTellJokeFragment,android.R.id.content);
    }

    @Override
    protected void onSetUpView(Bundle savedInstanceState) {

    }

    @Override
    protected void onSetEntry() {

    }
}
