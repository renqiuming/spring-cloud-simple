package com.rqm.tool;

import com.rqm.tool.thread.ThreadPoolManagementUtils;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static java.lang.Thread.sleep;

/**
 * @author renqiuming
 * @date 2020/2/11 下午4:16
 */
@SpringBootTest
public class HttpTest {
    final static int MAX_VALUE=5;

    /**
     * 抢票测试
     */
    @Test
    public void httpTest(String[] args) {

        for(int i=0;i<1;i++){
            try {
                // 5个线程同时抢票
                for(int j=0;j<MAX_VALUE;j++){
                    ThreadPoolManagementUtils.getMainThreadPool().execute(new Runnable() {
                        @Override
                        public void run() {
                            dTrade();
                        }
                    });
                }
                // 每1s抢一次
                sleep(1000);
            } catch (Exception e) {
                System.out.println("异常"+e);
            }
        }


    }

    /**
     * 大麦网抢票
     */
    private static void dTrade(){
        String cookies="cna=RODkErJORg0CAbStLJ0gsdir; cookie2=15bf9129760cf49bd320ccb9b2a3e644; t=da992d0074a626f74459ae73df03c4d1; _tb_token_=ee638be571b5a; l=AoWF82aqzVClBrqnwZJvyVbHFdq/QDnU; _hvn_login=18; munb=4015939499; csg=a926bb57; _m_h5_tk=30bbf183558b06a1933e6e0dcf496b24_1579520461416; _m_h5_tk_enc=548d18d6acae316cd252b31e6fff9e71; isg=BPHxrt9EC6USP6exL0ZeQab6AHuL3mVQuK0_bNMG6LjX-htMAS6HIBBbGYiccP2I; usercode=108183900; dm_nickname=%E9%BA%A6%E5%AD%906LEqi; userloginkey=fd09110863d14aab8d7fbf4d42b67d67_2_2; loginkey=fd09110863d14aab8d7fbf4d42b67d67_2_2; havanaId=4015939499";
        String path="";
        // 初始化结算页
        path="https://mtop.damai.cn/h5/mtop.trade.order.build.h5/4.0/?jsv=2.5.7&appKey=12574478&t=1579512529546&sign=62f1324098f5a21976ede6eee840de95&type=originaljson&dataType=json&v=4.0&H5Request=true&AntiCreep=true&AntiFlood=true&api=mtop.trade.order.build.h5&method=GET&ttid=%23t%23ip%23%23_h5_2014&globalCode=ali.china.damai&tb_eagleeyex_scm_project=20190509-aone2-join-test&data=%7B%22buyNow%22%3Atrue%2C%22buyParam%22%3A%22609624583698_2_4450010722494%22%2C%22exParams%22%3A%22%7B%5C%22channel%5C%22%3A%5C%22damai_app%5C%22%2C%5C%22damai%5C%22%3A%5C%221%5C%22%2C%5C%22umpChannel%5C%22%3A%5C%22100031004%5C%22%2C%5C%22subChannel%5C%22%3A%5C%22damai%40damaih5_h5%5C%22%2C%5C%22atomSplit%5C%22%3A1%2C%5C%22umidToken%5C%22%3A%5C%22TD1AEAE3879F14902B4DDED393E14109B7CD1B8CAFC52E684075F976577%5C%22%7D%22%2C%22dmChannel%22%3A%22damai%40damaih5_h5%22%7D&ua=122%230fKbJJsXEE%2BEH4pZy4pjEJponDJE7SNEEP7ZpJRBuDPpJFQLpCGwoHZDpJEL7SwBEyGZpJLlu4Ep%2BFQLpoGUEELWn4yE7SNEEP7ZpERBuDPE%2BBQPpC76EJponDJyKMQEIm5f0DnTcpbdfMFwkr7R%2FDUN%2BaWyhrItyajA6baRn46uqxmwhrmxjeaAASlK3Mp1uO0gDLVr8ph6%2B4EEyFfDqM3bDEpxngR4ul5EDOgPm4AiJDbEfC3mqM3WE8pangL4ul0EDLVr8CpU%2B4EEyFfDqMfbDEpxnSp4uOIEELXZ8oL6ywTEyF3fnW32DJp6dWG1ul58rkp8vB7QBDXBCmw6GRkbyKNkirNyAKcL%2F4zAk766QfDN0edJjFg%2FXXCXKCTegwKG3i%2FjRBF%2FIrxLuGonp3pGkBByPLQVUPhTSKhL112kjz9fnUF7EyUtvBtIx7OsqUMiPKGM5%2Fv6ZgFrNNG0AxST8P5AFLYRLS3OzvL%2BnR8QJCS8U3V8V9QVP4qy%2F5Z3GfNQuJrvNE7RQ%2BKKfxA1z520buKgDWw2duYdpFfSzw59JREXkTFp01Tf4PrHTfVm7B%2B9d3QNN4SPyTekEhAtf2ZMOmmTJg90dOZ%2FGuzzoXAJju5K04EABDrpQxlz3xl%2FvSc7wVSkYf3bCeJjVIZL%2FfeAooq1nGtDk6hBrAilnNE44SE6Ub7kuZvongaHNrH9KuE%2BRE%2FRBUrOaYkniRBtELNq%2Bbq48GR5oOz23NsgsPqzN9Hv6BYygWt%2FOHbnXlkqsc1iUz7fYWrqXlRBoDYIw0WI5DFwq13Ed53UQ%2B4AbB77USNPwRUUS1u%2FkyP9VKlWtugPhduorCNR6MbX6eHhkNG5BxpAmFamwvPMTnuNmODUtfxagx3UDi7%2BtrsTjxlhKPATVHsqU1boE3RqOQzxZhsNv7iTPvsRAn6lVVmHL8CMQLvIJ%2FYM3q7m2%2FrD4qLXjLsO4gsM3Foa";
        com.rqm.tool.http.HttpUtils.doHttp(path,cookies);
        // 勾选观演人
        path="https://wgo.mmstat.com/damai_m.default.click?gmkey=CLK&gokey=clicktitle%3D1%26havanaId%3D4015939499%26item_id%3D609624583698%26spm%3Da2o71.orderconfirm.buyperson.ditem_0%26usercode%3D108183900%26pu_i%3D108183900%26jsver%3Daplus_wap%26lver%3D8.12.13%26pver%3D0.7.10%26cache%3D778757a%26_slog%3D0&cna=RODkErJORg0CAbStLJ0gsdir&spm-cnt=a2o71.orderconfirm.0.0.5b155890prfUXy&logtype=2";
        com.rqm.tool.http.HttpUtils.doHttp(path,cookies);
        // 提交订单
        path="https://mtop.damai.cn/h5/mtop.trade.order.create.h5/4.0/?jsv=2.5.7&appKey=12574478&t=1579514344381&sign=b3b7ee9aa954a8353f2966170f0b0d68&v=4.0&post=1&type=originaljson&timeout=15000&dataType=json&isSec=1&ecode=1&H5Request=true&needLogin=true&AntiCreep=true&ttid=%23t%23ip%23%23_h5_2014&globalCode=ali.china.damai&tb_eagleeyex_scm_project=20190509-aone2-join-test&api=mtop.trade.order.create.h5&submitref=9f2aa5247298223269fb2a9f51e5ac99";
        String param="data=%7B%22params%22%3A%22%7B%5C%22data%5C%22%3A%5C%22%7B%5C%5C%5C%22dmDeliveryAddress_1957%5C%5C%5C%22%3A%7B%5C%5C%5C%22ref%5C%5C%5C%22%3A%5C%5C%5C%2243624bf%5C%5C%5C%22%2C%5C%5C%5C%22submit%5C%5C%5C%22%3Atrue%2C%5C%5C%5C%22id%5C%5C%5C%22%3A%5C%5C%5C%221957%5C%5C%5C%22%2C%5C%5C%5C%22tag%5C%5C%5C%22%3A%5C%5C%5C%22dmDeliveryAddress%5C%5C%5C%22%2C%5C%5C%5C%22type%5C%5C%5C%22%3A%5C%5C%5C%22dinamicx%243110%24dmdeliveryaddress201904%5C%5C%5C%22%2C%5C%5C%5C%22fields%5C%5C%5C%22%3A%7B%5C%5C%5C%22phoneTitle%5C%5C%5C%22%3A%5C%5C%5C%22%E7%94%B5%E8%AF%9D%5C%5C%5C%22%2C%5C%5C%5C%22address%5C%5C%5C%22%3A%5C%5C%5C%22%E4%B8%8A%E6%B5%B7%E4%B8%8A%E6%B5%B7%E5%B8%82%E6%B5%A6%E4%B8%9C%E6%96%B0%E5%8C%BA%E5%8C%97%E8%94%A1%E9%95%87%E4%B8%8B%E5%8D%97%E8%B7%AF339%E5%BC%8459%E5%8F%B7602%5C%5C%5C%22%2C%5C%5C%5C%22consignee%5C%5C%5C%22%3A%5C%5C%5C%22%E6%9D%A8%E6%9F%B3%5C%5C%5C%22%2C%5C%5C%5C%22addressTitle%5C%5C%5C%22%3A%5C%5C%5C%22%E6%94%B6%E8%B4%A7%E5%9C%B0%E5%9D%80%5C%5C%5C%22%2C%5C%5C%5C%22phone%5C%5C%5C%22%3A%5C%5C%5C%2215618867750%5C%5C%5C%22%2C%5C%5C%5C%22consigneeTitle%5C%5C%5C%22%3A%5C%5C%5C%22%E6%94%B6%E4%BB%B6%E4%BA%BA%5C%5C%5C%22%2C%5C%5C%5C%22addressStatus%5C%5C%5C%22%3A0%2C%5C%5C%5C%22addressId%5C%5C%5C%22%3A102748938%7D%2C%5C%5C%5C%22events%5C%5C%5C%22%3A%7B%5C%5C%5C%22addressClick%5C%5C%5C%22%3A%5B%7B%5C%5C%5C%22tag%5C%5C%5C%22%3A%5C%5C%5C%22openPopupWindow%5C%5C%5C%22%2C%5C%5C%5C%22type%5C%5C%5C%22%3A%5C%5C%5C%22openPopupWindow%5C%5C%5C%22%2C%5C%5C%5C%22fields%5C%5C%5C%22%3A%7B%5C%5C%5C%22css%5C%5C%5C%22%3A%7B%5C%5C%5C%22height%5C%5C%5C%22%3A%5C%5C%5C%220.6%5C%5C%5C%22%7D%2C%5C%5C%5C%22options%5C%5C%5C%22%3A%7B%5C%5C%5C%22needCloseButton%5C%5C%5C%22%3A%5C%5C%5C%22true%5C%5C%5C%22%7D%2C%5C%5C%5C%22nextRenderRoot%5C%5C%5C%22%3A%5C%5C%5C%22dmDeliveryAddressSelectPopupWindowBlock_1957_window_root%5C%5C%5C%22%2C%5C%5C%5C%22params%5C%5C%5C%22%3A%7B%7D%7D%7D%5D%7D%7D%2C%5C%5C%5C%22item_06a543ed0426928b84c79d333729417d%5C%5C%5C%22%3A%7B%5C%5C%5C%22ref%5C%5C%5C%22%3A%5C%5C%5C%22360f46f%5C%5C%5C%22%2C%5C%5C%5C%22submit%5C%5C%5C%22%3Atrue%2C%5C%5C%5C%22hidden%5C%5C%5C%22%3A%7B%5C%5C%5C%22extensionMap%5C%5C%5C%22%3A%7B%5C%5C%5C%22valid%5C%5C%5C%22%3A%5C%5C%5C%22true%5C%5C%5C%22%2C%5C%5C%5C%22itemId%5C%5C%5C%22%3A%5C%5C%5C%22609624583698%5C%5C%5C%22%2C%5C%5C%5C%22bizCode%5C%5C%5C%22%3A%5C%5C%5C%22ali.china.damai%5C%5C%5C%22%2C%5C%5C%5C%22cartId%5C%5C%5C%22%3A%5C%5C%5C%220%5C%5C%5C%22%2C%5C%5C%5C%22shoppingOrderId%5C%5C%5C%22%3A%5C%5C%5C%220%5C%5C%5C%22%2C%5C%5C%5C%22villagerId%5C%5C%5C%22%3A%5C%5C%5C%220%5C%5C%5C%22%2C%5C%5C%5C%22skuId%5C%5C%5C%22%3A%5C%5C%5C%224450010722494%5C%5C%5C%22%7D%7D%2C%5C%5C%5C%22id%5C%5C%5C%22%3A%5C%5C%5C%2206a543ed0426928b84c79d333729417d%5C%5C%5C%22%2C%5C%5C%5C%22tag%5C%5C%5C%22%3A%5C%5C%5C%22item%5C%5C%5C%22%2C%5C%5C%5C%22type%5C%5C%5C%22%3A%5C%5C%5C%22block%24null%24emptyBlock%5C%5C%5C%22%2C%5C%5C%5C%22fields%5C%5C%5C%22%3A%7B%7D%7D%2C%5C%5C%5C%22dmContactEmail_1968%5C%5C%5C%22%3A%7B%5C%5C%5C%22ref%5C%5C%5C%22%3A%5C%5C%5C%2263ba2eb%5C%5C%5C%22%2C%5C%5C%5C%22submit%5C%5C%5C%22%3Atrue%2C%5C%5C%5C%22id%5C%5C%5C%22%3A%5C%5C%5C%221968%5C%5C%5C%22%2C%5C%5C%5C%22tag%5C%5C%5C%22%3A%5C%5C%5C%22dmContactEmail%5C%5C%5C%22%2C%5C%5C%5C%22type%5C%5C%5C%22%3A%5C%5C%5C%22dinamicx%243128%24dminput%5C%5C%5C%22%2C%5C%5C%5C%22fields%5C%5C%5C%22%3A%7B%5C%5C%5C%22label%5C%5C%5C%22%3A%5C%5C%5C%22%E9%82%AE%E7%AE%B1%5C%5C%5C%22%2C%5C%5C%5C%22placeholder%5C%5C%5C%22%3A%5C%5C%5C%22%E8%AF%B7%E5%A1%AB%E5%86%99%E8%81%94%E7%B3%BB%E4%BA%BA%E9%82%AE%E7%AE%B1%5C%5C%5C%22%7D%2C%5C%5C%5C%22events%5C%5C%5C%22%3A%7B%5C%5C%5C%22onFinish%5C%5C%5C%22%3A%5B%7B%5C%5C%5C%22tag%5C%5C%5C%22%3A%5C%5C%5C%22input%5C%5C%5C%22%2C%5C%5C%5C%22type%5C%5C%5C%22%3A%5C%5C%5C%22input%5C%5C%5C%22%2C%5C%5C%5C%22fields%5C%5C%5C%22%3A%7B%7D%7D%5D%7D%2C%5C%5C%5C%22validate%5C%5C%5C%22%3A%7B%5C%5C%5C%22msg%5C%5C%5C%22%3A%5B%5C%5C%5C%22%E8%AF%B7%E5%A1%AB%E5%86%99%E8%81%94%E7%B3%BB%E4%BA%BA%E9%82%AE%E7%AE%B1%5C%5C%5C%22%5D%2C%5C%5C%5C%22regex%5C%5C%5C%22%3A%5B%5C%5C%5C%22%5E%5B%5C%5C%5C%5C%5C%5C%5C%5CS%5D%2B%24%5C%5C%5C%22%5D%2C%5C%5C%5C%22fields%5C%5C%5C%22%3A%5B%5C%5C%5C%22value%5C%5C%5C%22%5D%7D%2C%5C%5C%5C%22status%5C%5C%5C%22%3A%5C%5C%5C%22hidden%5C%5C%5C%22%7D%2C%5C%5C%5C%22dmContactPhone_1967%5C%5C%5C%22%3A%7B%5C%5C%5C%22ref%5C%5C%5C%22%3A%5C%5C%5C%221934a29%5C%5C%5C%22%2C%5C%5C%5C%22submit%5C%5C%5C%22%3Atrue%2C%5C%5C%5C%22id%5C%5C%5C%22%3A%5C%5C%5C%221967%5C%5C%5C%22%2C%5C%5C%5C%22tag%5C%5C%5C%22%3A%5C%5C%5C%22dmContactPhone%5C%5C%5C%22%2C%5C%5C%5C%22type%5C%5C%5C%22%3A%5C%5C%5C%22dinamicx%243116%24dmcontactsphone201904%5C%5C%5C%22%2C%5C%5C%5C%22fields%5C%5C%5C%22%3A%7B%5C%5C%5C%22placeholder%5C%5C%5C%22%3A%5C%5C%5C%22%E8%AF%B7%E5%A1%AB%E5%86%99%E8%81%94%E7%B3%BB%E4%BA%BA%E6%89%8B%E6%9C%BA%E5%8F%B7%5C%5C%5C%22%2C%5C%5C%5C%22label%5C%5C%5C%22%3A%5C%5C%5C%22%E6%89%8B%E6%9C%BA%E5%8F%B7%5C%5C%5C%22%2C%5C%5C%5C%22list%5C%5C%5C%22%3A%5B%7B%5C%5C%5C%22area%5C%5C%5C%22%3A%5C%5C%5C%22%E4%B8%AD%E5%9B%BD%E5%A4%A7%E9%99%86%5C%5C%5C%22%2C%5C%5C%5C%22code%5C%5C%5C%22%3A%5C%5C%5C%22%2B86%5C%5C%5C%22%7D%2C%7B%5C%5C%5C%22area%5C%5C%5C%22%3A%5C%5C%5C%22%E4%B8%AD%E5%9B%BD%E9%A6%99%E6%B8%AF%5C%5C%5C%22%2C%5C%5C%5C%22code%5C%5C%5C%22%3A%5C%5C%5C%22%2B852%5C%5C%5C%22%7D%2C%7B%5C%5C%5C%22area%5C%5C%5C%22%3A%5C%5C%5C%22%E4%B8%AD%E5%9B%BD%E6%BE%B3%E9%97%A8%5C%5C%5C%22%2C%5C%5C%5C%22code%5C%5C%5C%22%3A%5C%5C%5C%22%2B853%5C%5C%5C%22%7D%2C%7B%5C%5C%5C%22area%5C%5C%5C%22%3A%5C%5C%5C%22%E4%B8%AD%E5%9B%BD%E5%8F%B0%E6%B9%BE%5C%5C%5C%22%2C%5C%5C%5C%22code%5C%5C%5C%22%3A%5C%5C%5C%22%2B886%5C%5C%5C%22%7D%5D%2C%5C%5C%5C%22value%5C%5C%5C%22%3A%5C%5C%5C%2215618867750%5C%5C%5C%22%2C%5C%5C%5C%22selectedIndex%5C%5C%5C%22%3A0%7D%2C%5C%5C%5C%22events%5C%5C%5C%22%3A%7B%5C%5C%5C%22itemClick%5C%5C%5C%22%3A%5B%7B%5C%5C%5C%22tag%5C%5C%5C%22%3A%5C%5C%5C%22openPopupWindow%5C%5C%5C%22%2C%5C%5C%5C%22type%5C%5C%5C%22%3A%5C%5C%5C%22openPopupWindow%5C%5C%5C%22%2C%5C%5C%5C%22fields%5C%5C%5C%22%3A%7B%5C%5C%5C%22css%5C%5C%5C%22%3A%7B%5C%5C%5C%22height%5C%5C%5C%22%3A%5C%5C%5C%220.6%5C%5C%5C%22%7D%2C%5C%5C%5C%22options%5C%5C%5C%22%3A%7B%5C%5C%5C%22needCloseButton%5C%5C%5C%22%3A%5C%5C%5C%22true%5C%5C%5C%22%7D%2C%5C%5C%5C%22nextRenderRoot%5C%5C%5C%22%3A%5C%5C%5C%22dmContactPhoneAreaCodeSelectPopupWindowBlock_dmContactPhoneAreaCodeSelectPopupWindowBlock__window_root%5C%5C%5C%22%2C%5C%5C%5C%22params%5C%5C%5C%22%3A%7B%5C%5C%5C%22phoneAreaCodeEntries%5C%5C%5C%22%3A%5C%5C%5C%22%5B%7B%5C%5C%5C%5C%5C%5C%5C%22area%5C%5C%5C%5C%5C%5C%5C%22%3A%5C%5C%5C%5C%5C%5C%5C%22%E4%B8%AD%E5%9B%BD%E5%A4%A7%E9%99%86%5C%5C%5C%5C%5C%5C%5C%22%2C%5C%5C%5C%5C%5C%5C%5C%22code%5C%5C%5C%5C%5C%5C%5C%22%3A%5C%5C%5C%5C%5C%5C%5C%22%2B86%5C%5C%5C%5C%5C%5C%5C%22%7D%2C%7B%5C%5C%5C%5C%5C%5C%5C%22area%5C%5C%5C%5C%5C%5C%5C%22%3A%5C%5C%5C%5C%5C%5C%5C%22%E4%B8%AD%E5%9B%BD%E9%A6%99%E6%B8%AF%5C%5C%5C%5C%5C%5C%5C%22%2C%5C%5C%5C%5C%5C%5C%5C%22code%5C%5C%5C%5C%5C%5C%5C%22%3A%5C%5C%5C%5C%5C%5C%5C%22%2B852%5C%5C%5C%5C%5C%5C%5C%22%7D%2C%7B%5C%5C%5C%5C%5C%5C%5C%22area%5C%5C%5C%5C%5C%5C%5C%22%3A%5C%5C%5C%5C%5C%5C%5C%22%E4%B8%AD%E5%9B%BD%E6%BE%B3%E9%97%A8%5C%5C%5C%5C%5C%5C%5C%22%2C%5C%5C%5C%5C%5C%5C%5C%22code%5C%5C%5C%5C%5C%5C%5C%22%3A%5C%5C%5C%5C%5C%5C%5C%22%2B853%5C%5C%5C%5C%5C%5C%5C%22%7D%2C%7B%5C%5C%5C%5C%5C%5C%5C%22area%5C%5C%5C%5C%5C%5C%5C%22%3A%5C%5C%5C%5C%5C%5C%5C%22%E4%B8%AD%E5%9B%BD%E5%8F%B0%E6%B9%BE%5C%5C%5C%5C%5C%5C%5C%22%2C%5C%5C%5C%5C%5C%5C%5C%22code%5C%5C%5C%5C%5C%5C%5C%22%3A%5C%5C%5C%5C%5C%5C%5C%22%2B886%5C%5C%5C%5C%5C%5C%5C%22%7D%5D%5C%5C%5C%22%7D%7D%7D%5D%2C%5C%5C%5C%22onFinish%5C%5C%5C%22%3A%5B%7B%5C%5C%5C%22tag%5C%5C%5C%22%3A%5C%5C%5C%22input%5C%5C%5C%22%2C%5C%5C%5C%22type%5C%5C%5C%22%3A%5C%5C%5C%22input%5C%5C%5C%22%2C%5C%5C%5C%22fields%5C%5C%5C%22%3A%7B%5C%5C%5C%22value%5C%5C%5C%22%3A%5C%5C%5C%2215618867750%5C%5C%5C%22%7D%7D%5D%7D%2C%5C%5C%5C%22validate%5C%5C%5C%22%3A%7B%5C%5C%5C%22msg%5C%5C%5C%22%3A%5B%5C%5C%5C%22%E8%AF%B7%E5%A1%AB%E5%86%99%E8%81%94%E7%B3%BB%E4%BA%BA%E6%89%8B%E6%9C%BA%E5%8F%B7%5C%5C%5C%22%5D%2C%5C%5C%5C%22regex%5C%5C%5C%22%3A%5B%5C%5C%5C%22%5E%5B%5C%5C%5C%5C%5C%5C%5C%5CS%5D%2B%24%5C%5C%5C%22%5D%2C%5C%5C%5C%22fields%5C%5C%5C%22%3A%5B%5C%5C%5C%22value%5C%5C%5C%22%5D%7D%2C%5C%5C%5C%22status%5C%5C%5C%22%3A%5C%5C%5C%22hidden%5C%5C%5C%22%7D%2C%5C%5C%5C%22dmProtocol_1976%5C%5C%5C%22%3A%7B%5C%5C%5C%22ref%5C%5C%5C%22%3A%5C%5C%5C%22e84b3ff%5C%5C%5C%22%2C%5C%5C%5C%22submit%5C%5C%5C%22%3Atrue%2C%5C%5C%5C%22id%5C%5C%5C%22%3A%5C%5C%5C%221976%5C%5C%5C%22%2C%5C%5C%5C%22tag%5C%5C%5C%22%3A%5C%5C%5C%22dmProtocol%5C%5C%5C%22%2C%5C%5C%5C%22position%5C%5C%5C%22%3A%5C%5C%5C%22footer%5C%5C%5C%22%2C%5C%5C%5C%22type%5C%5C%5C%22%3A%5C%5C%5C%22dinamicx%243125%24dmprotocolcheckbox%5C%5C%5C%22%2C%5C%5C%5C%22fields%5C%5C%5C%22%3A%7B%5C%5C%5C%22background%5C%5C%5C%22%3A%5C%5C%5C%22%23FFFFFF%5C%5C%5C%22%2C%5C%5C%5C%22richTextCss%5C%5C%5C%22%3A%7B%5C%5C%5C%22textColor%5C%5C%5C%22%3A%5C%5C%5C%22%2330AEFF%5C%5C%5C%22%2C%5C%5C%5C%22textSize%5C%5C%5C%22%3A%5C%5C%5C%2212%5C%5C%5C%22%7D%2C%5C%5C%5C%22richTextUrl%5C%5C%5C%22%3A%5B%5C%5C%5C%22https%3A%2F%2Fx.damai.cn%2Fmarkets%2Fapp%2Fagreements%5C%5C%5C%22%5D%2C%5C%5C%5C%22submitTarget%5C%5C%5C%22%3A%5C%5C%5C%22dmSubmit_1977%5C%5C%5C%22%2C%5C%5C%5C%22richText%5C%5C%5C%22%3A%5B%5C%5C%5C%22%E3%80%8A%E5%A4%A7%E9%BA%A6%E7%BD%91%E8%AE%A2%E7%A5%A8%E6%9C%8D%E5%8A%A1%E6%9D%A1%E6%AC%BE%E3%80%8B%5C%5C%5C%22%5D%2C%5C%5C%5C%22title%5C%5C%5C%22%3A%5C%5C%5C%22%E5%90%8C%E6%84%8F%5C%5C%5C%22%2C%5C%5C%5C%22isChecked%5C%5C%5C%22%3Atrue%7D%2C%5C%5C%5C%22events%5C%5C%5C%22%3A%7B%5C%5C%5C%22itemClick%5C%5C%5C%22%3A%5B%7B%5C%5C%5C%22tag%5C%5C%5C%22%3A%5C%5C%5C%22select%5C%5C%5C%22%2C%5C%5C%5C%22type%5C%5C%5C%22%3A%5C%5C%5C%22select%5C%5C%5C%22%2C%5C%5C%5C%22fields%5C%5C%5C%22%3A%7B%7D%7D%5D%2C%5C%5C%5C%22richTextClick%5C%5C%5C%22%3A%5B%7B%5C%5C%5C%22tag%5C%5C%5C%22%3A%5C%5C%5C%22autoJumpOpenUrl%5C%5C%5C%22%2C%5C%5C%5C%22type%5C%5C%5C%22%3A%5C%5C%5C%22autoJumpOpenUrl%5C%5C%5C%22%2C%5C%5C%5C%22fields%5C%5C%5C%22%3A%7B%5C%5C%5C%22pageType%5C%5C%5C%22%3A%5C%5C%5C%22H5%5C%5C%5C%22%2C%5C%5C%5C%22url%5C%5C%5C%22%3A%5C%5C%5C%22%5Bhttps%3A%2F%2Fx.damai.cn%2Fmarkets%2Fapp%2Fagreements%5D%5C%5C%5C%22%7D%7D%5D%7D%2C%5C%5C%5C%22validate%5C%5C%5C%22%3A%7B%5C%5C%5C%22msg%5C%5C%5C%22%3A%5B%5C%5C%5C%22%E8%AF%B7%E9%98%85%E8%AF%BB%E6%9C%8D%E5%8A%A1%E6%9D%A1%E6%AC%BE%E5%B9%B6%E5%90%8C%E6%84%8F%5C%5C%5C%22%5D%2C%5C%5C%5C%22regex%5C%5C%5C%22%3A%5B%5C%5C%5C%22%5Etrue%24%5C%5C%5C%22%5D%2C%5C%5C%5C%22fields%5C%5C%5C%22%3A%5B%5C%5C%5C%22isChecked%5C%5C%5C%22%5D%7D%7D%2C%5C%5C%5C%22item_7d81f10a76fdc9ed57b7b9730f6e1e70%5C%5C%5C%22%3A%7B%5C%5C%5C%22ref%5C%5C%5C%22%3A%5C%5C%5C%22360f46f%5C%5C%5C%22%2C%5C%5C%5C%22submit%5C%5C%5C%22%3Atrue%2C%5C%5C%5C%22hidden%5C%5C%5C%22%3A%7B%5C%5C%5C%22extensionMap%5C%5C%5C%22%3A%7B%5C%5C%5C%22valid%5C%5C%5C%22%3A%5C%5C%5C%22true%5C%5C%5C%22%2C%5C%5C%5C%22itemId%5C%5C%5C%22%3A%5C%5C%5C%22609624583698%5C%5C%5C%22%2C%5C%5C%5C%22bizCode%5C%5C%5C%22%3A%5C%5C%5C%22ali.china.damai%5C%5C%5C%22%2C%5C%5C%5C%22cartId%5C%5C%5C%22%3A%5C%5C%5C%220%5C%5C%5C%22%2C%5C%5C%5C%22shoppingOrderId%5C%5C%5C%22%3A%5C%5C%5C%220%5C%5C%5C%22%2C%5C%5C%5C%22villagerId%5C%5C%5C%22%3A%5C%5C%5C%220%5C%5C%5C%22%2C%5C%5C%5C%22skuId%5C%5C%5C%22%3A%5C%5C%5C%224450010722494%5C%5C%5C%22%7D%7D%2C%5C%5C%5C%22id%5C%5C%5C%22%3A%5C%5C%5C%227d81f10a76fdc9ed57b7b9730f6e1e70%5C%5C%5C%22%2C%5C%5C%5C%22tag%5C%5C%5C%22%3A%5C%5C%5C%22item%5C%5C%5C%22%2C%5C%5C%5C%22type%5C%5C%5C%22%3A%5C%5C%5C%22block%24null%24emptyBlock%5C%5C%5C%22%2C%5C%5C%5C%22fields%5C%5C%5C%22%3A%7B%7D%7D%2C%5C%5C%5C%22dmEttributesHiddenBlock_DmAttributesBlock%5C%5C%5C%22%3A%7B%5C%5C%5C%22ref%5C%5C%5C%22%3A%5C%5C%5C%223dea421%5C%5C%5C%22%2C%5C%5C%5C%22submit%5C%5C%5C%22%3Atrue%2C%5C%5C%5C%22id%5C%5C%5C%22%3A%5C%5C%5C%22DmAttributesBlock%5C%5C%5C%22%2C%5C%5C%5C%22tag%5C%5C%5C%22%3A%5C%5C%5C%22dmEttributesHiddenBlock%5C%5C%5C%22%2C%5C%5C%5C%22type%5C%5C%5C%22%3A%5C%5C%5C%22block%24null%24dmettributeshidden%5C%5C%5C%22%2C%5C%5C%5C%22fields%5C%5C%5C%22%3A%7B%5C%5C%5C%22extraAttributes%5C%5C%5C%22%3A%5C%5C%5C%22%7B%5C%5C%5C%5C%5C%5C%5C%22finalRenderTraceId%5C%5C%5C%5C%5C%5C%5C%22%3A%5C%5C%5C%5C%5C%5C%5C%220b52072815795152667603579ec26a%5C%5C%5C%5C%5C%5C%5C%22%2C%5C%5C%5C%5C%5C%5C%5C%22renderTraceId%5C%5C%5C%5C%5C%5C%5C%22%3A%5C%5C%5C%5C%5C%5C%5C%220b52072815795152667603579ec26a%5C%5C%5C%5C%5C%5C%5C%22%7D%5C%5C%5C%22%7D%7D%2C%5C%5C%5C%22dmPayType_1972%5C%5C%5C%22%3A%7B%5C%5C%5C%22ref%5C%5C%5C%22%3A%5C%5C%5C%22b7922c3%5C%5C%5C%22%2C%5C%5C%5C%22submit%5C%5C%5C%22%3Atrue%2C%5C%5C%5C%22id%5C%5C%5C%22%3A%5C%5C%5C%221972%5C%5C%5C%22%2C%5C%5C%5C%22tag%5C%5C%5C%22%3A%5C%5C%5C%22dmPayType%5C%5C%5C%22%2C%5C%5C%5C%22type%5C%5C%5C%22%3A%5C%5C%5C%22native%24null%24dmpaytype%5C%5C%5C%22%2C%5C%5C%5C%22fields%5C%5C%5C%22%3A%7B%5C%5C%5C%22allTip%5C%5C%5C%22%3A%5C%5C%5C%22%E5%85%B6%E4%BB%96%E6%94%AF%E4%BB%98%E6%96%B9%E5%BC%8F%5C%5C%5C%22%2C%5C%5C%5C%22paytypeList%5C%5C%5C%22%3A%5B%7B%5C%5C%5C%22code%5C%5C%5C%22%3A%5C%5C%5C%22ALIPAY_WAP%5C%5C%5C%22%2C%5C%5C%5C%22icon%5C%5C%5C%22%3A%5C%5C%5C%22https%3A%2F%2Fgw.alicdn.com%2Ftfs%2FTB1_bcpdStYBeNjSspkXXbU8VXa-64-64.png%5C%5C%5C%22%2C%5C%5C%5C%22isUsed%5C%5C%5C%22%3Atrue%2C%5C%5C%5C%22name%5C%5C%5C%22%3A%5C%5C%5C%22%E6%94%AF%E4%BB%98%E5%AE%9D%5C%5C%5C%22%7D%5D%7D%2C%5C%5C%5C%22events%5C%5C%5C%22%3A%7B%5C%5C%5C%22itemClick%5C%5C%5C%22%3A%5B%7B%5C%5C%5C%22tag%5C%5C%5C%22%3A%5C%5C%5C%22select%5C%5C%5C%22%2C%5C%5C%5C%22type%5C%5C%5C%22%3A%5C%5C%5C%22select%5C%5C%5C%22%2C%5C%5C%5C%22fields%5C%5C%5C%22%3A%7B%7D%7D%5D%7D%7D%2C%5C%5C%5C%22dmDeliverySelectCard_1955%5C%5C%5C%22%3A%7B%5C%5C%5C%22ref%5C%5C%5C%22%3A%5C%5C%5C%22954e85d%5C%5C%5C%22%2C%5C%5C%5C%22submit%5C%5C%5C%22%3Atrue%2C%5C%5C%5C%22id%5C%5C%5C%22%3A%5C%5C%5C%221955%5C%5C%5C%22%2C%5C%5C%5C%22tag%5C%5C%5C%22%3A%5C%5C%5C%22dmDeliverySelectCard%5C%5C%5C%22%2C%5C%5C%5C%22type%5C%5C%5C%22%3A%5C%5C%5C%22dinamicx%243127%24dmselectheader%5C%5C%5C%22%2C%5C%5C%5C%22fields%5C%5C%5C%22%3A%7B%5C%5C%5C%22tipInfo%5C%5C%5C%22%3A%5C%5C%5C%22%5C%5C%5C%22%2C%5C%5C%5C%22selectedId%5C%5C%5C%22%3A%5C%5C%5C%222%5C%5C%5C%22%2C%5C%5C%5C%22extraLink%5C%5C%5C%22%3Afalse%2C%5C%5C%5C%22title%5C%5C%5C%22%3A%5C%5C%5C%22%E9%85%8D%E9%80%81%E6%96%B9%E5%BC%8F%5C%5C%5C%22%2C%5C%5C%5C%22desc%5C%5C%5C%22%3A%5C%5C%5C%22%E5%BF%AB%E9%80%92%5C%5C%5C%22%7D%7D%2C%5C%5C%5C%22confirmOrder_1%5C%5C%5C%22%3A%7B%5C%5C%5C%22ref%5C%5C%5C%22%3A%5C%5C%5C%228318d7a%5C%5C%5C%22%2C%5C%5C%5C%22submit%5C%5C%5C%22%3Atrue%2C%5C%5C%5C%22hidden%5C%5C%5C%22%3A%7B%5C%5C%5C%22extensionMap%5C%5C%5C%22%3A%7B%5C%5C%5C%22pageType%5C%5C%5C%22%3A%5C%5C%5C%22DAMAI%5C%5C%5C%22%2C%5C%5C%5C%22umid%5C%5C%5C%22%3A%5C%5C%5C%22%5C%5C%5C%22%2C%5C%5C%5C%22__ex_params__%5C%5C%5C%22%3A%5C%5C%5C%22%7B%5C%5C%5C%5C%5C%5C%5C%22umpChannel%5C%5C%5C%5C%5C%5C%5C%22%3A%5C%5C%5C%5C%5C%5C%5C%22100031004%5C%5C%5C%5C%5C%5C%5C%22%2C%5C%5C%5C%5C%5C%5C%5C%22damai%5C%5C%5C%5C%5C%5C%5C%22%3A%5C%5C%5C%5C%5C%5C%5C%221%5C%5C%5C%5C%5C%5C%5C%22%2C%5C%5C%5C%5C%5C%5C%5C%22channel%5C%5C%5C%5C%5C%5C%5C%22%3A%5C%5C%5C%5C%5C%5C%5C%22damai_app%5C%5C%5C%5C%5C%5C%5C%22%2C%5C%5C%5C%5C%5C%5C%5C%22subChannel%5C%5C%5C%5C%5C%5C%5C%22%3A%5C%5C%5C%5C%5C%5C%5C%22damai%40damaih5_h5%5C%5C%5C%5C%5C%5C%5C%22%2C%5C%5C%5C%5C%5C%5C%5C%22atomSplit%5C%5C%5C%5C%5C%5C%5C%22%3A%5C%5C%5C%5C%5C%5C%5C%221%5C%5C%5C%5C%5C%5C%5C%22%2C%5C%5C%5C%5C%5C%5C%5C%22umidToken%5C%5C%5C%5C%5C%5C%5C%22%3A%5C%5C%5C%5C%5C%5C%5C%22TE69503E26022154A75ECBF84E9E10723B6D24D286F347A493A390AAA18%5C%5C%5C%5C%5C%5C%5C%22%7D%5C%5C%5C%22%2C%5C%5C%5C%22joinId%5C%5C%5C%22%3A%5C%5C%5C%227d81f10a76fdc9ed57b7b9730f6e1e70%5C%5C%5C%22%7D%7D%2C%5C%5C%5C%22id%5C%5C%5C%22%3A%5C%5C%5C%221%5C%5C%5C%22%2C%5C%5C%5C%22tag%5C%5C%5C%22%3A%5C%5C%5C%22confirmOrder%5C%5C%5C%22%2C%5C%5C%5C%22type%5C%5C%5C%22%3A%5C%5C%5C%22block%24null%24emptyBlock%5C%5C%5C%22%2C%5C%5C%5C%22fields%5C%5C%5C%22%3A%7B%7D%7D%2C%5C%5C%5C%22dmViewer_1953%5C%5C%5C%22%3A%7B%5C%5C%5C%22ref%5C%5C%5C%22%3A%5C%5C%5C%22cba4eb8%5C%5C%5C%22%2C%5C%5C%5C%22submit%5C%5C%5C%22%3Atrue%2C%5C%5C%5C%22id%5C%5C%5C%22%3A%5C%5C%5C%221953%5C%5C%5C%22%2C%5C%5C%5C%22tag%5C%5C%5C%22%3A%5C%5C%5C%22dmViewer%5C%5C%5C%22%2C%5C%5C%5C%22type%5C%5C%5C%22%3A%5C%5C%5C%22native%24null%24dmviewer%5C%5C%5C%22%2C%5C%5C%5C%22fields%5C%5C%5C%22%3A%7B%5C%5C%5C%22omitDisplaySum%5C%5C%5C%22%3A20%2C%5C%5C%5C%22buyerTotalNum%5C%5C%5C%22%3A1%2C%5C%5C%5C%22idTypes%5C%5C%5C%22%3A%5C%5C%5C%221%5C%5C%5C%22%2C%5C%5C%5C%22asyncTarget%5C%5C%5C%22%3A%5C%5C%5C%22dmViewerTitle_1953%5C%5C%5C%22%2C%5C%5C%5C%22expandTip%5C%5C%5C%22%3A%5C%5C%5C%22%E5%85%A8%E9%83%A8%E8%A7%82%E6%BC%94%E4%BA%BA%5C%5C%5C%22%2C%5C%5C%5C%22viewerList%5C%5C%5C%22%3A%5B%7B%5C%5C%5C%22hashIdentityNo%5C%5C%5C%22%3A%5C%5C%5C%22230************628%5C%5C%5C%22%2C%5C%5C%5C%22idType%5C%5C%5C%22%3A1%2C%5C%5C%5C%22idTypeDesc%5C%5C%5C%22%3A%5C%5C%5C%22%E8%BA%AB%E4%BB%BD%E8%AF%81%5C%5C%5C%22%2C%5C%5C%5C%22identityNo%5C%5C%5C%22%3A%5C%5C%5C%22230704198905180628%5C%5C%5C%22%2C%5C%5C%5C%22isDisabled%5C%5C%5C%22%3Afalse%2C%5C%5C%5C%22isUsed%5C%5C%5C%22%3Atrue%2C%5C%5C%5C%22viewerId%5C%5C%5C%22%3A%5C%5C%5C%2211000f153c41827a18a00fbcc82279685a061153d0684%5C%5C%5C%22%2C%5C%5C%5C%22viewerName%5C%5C%5C%22%3A%5C%5C%5C%22%E6%9D%A8%E6%9F%B3%5C%5C%5C%22%7D%5D%2C%5C%5C%5C%22selectedNum%5C%5C%5C%22%3A1%7D%2C%5C%5C%5C%22validate%5C%5C%5C%22%3A%7B%5C%5C%5C%22msg%5C%5C%5C%22%3A%5B%5C%5C%5C%22%E5%85%B1%E9%9C%80%E9%80%89%E6%8B%A91%E4%BD%8D%E8%A7%82%E6%BC%94%E4%BA%BA%5C%5C%5C%22%5D%2C%5C%5C%5C%22regex%5C%5C%5C%22%3A%5B%5C%5C%5C%221%5C%5C%5C%22%5D%2C%5C%5C%5C%22fields%5C%5C%5C%22%3A%5B%5C%5C%5C%22selectedNum%5C%5C%5C%22%5D%7D%7D%2C%5C%5C%5C%22dmContactName_1966%5C%5C%5C%22%3A%7B%5C%5C%5C%22ref%5C%5C%5C%22%3A%5C%5C%5C%2260f80d3%5C%5C%5C%22%2C%5C%5C%5C%22submit%5C%5C%5C%22%3Atrue%2C%5C%5C%5C%22id%5C%5C%5C%22%3A%5C%5C%5C%221966%5C%5C%5C%22%2C%5C%5C%5C%22tag%5C%5C%5C%22%3A%5C%5C%5C%22dmContactName%5C%5C%5C%22%2C%5C%5C%5C%22type%5C%5C%5C%22%3A%5C%5C%5C%22dinamicx%243128%24dminput%5C%5C%5C%22%2C%5C%5C%5C%22fields%5C%5C%5C%22%3A%7B%5C%5C%5C%22label%5C%5C%5C%22%3A%5C%5C%5C%22%E5%A7%93%E5%90%8D%5C%5C%5C%22%2C%5C%5C%5C%22placeholder%5C%5C%5C%22%3A%5C%5C%5C%22%E8%AF%B7%E5%A1%AB%E5%86%99%E8%81%94%E7%B3%BB%E4%BA%BA%E5%A7%93%E5%90%8D%5C%5C%5C%22%2C%5C%5C%5C%22value%5C%5C%5C%22%3A%5C%5C%5C%22%E6%9D%A8%E6%9F%B3%5C%5C%5C%22%7D%2C%5C%5C%5C%22events%5C%5C%5C%22%3A%7B%5C%5C%5C%22onFinish%5C%5C%5C%22%3A%5B%7B%5C%5C%5C%22tag%5C%5C%5C%22%3A%5C%5C%5C%22input%5C%5C%5C%22%2C%5C%5C%5C%22type%5C%5C%5C%22%3A%5C%5C%5C%22input%5C%5C%5C%22%2C%5C%5C%5C%22fields%5C%5C%5C%22%3A%7B%5C%5C%5C%22value%5C%5C%5C%22%3A%5C%5C%5C%22%E6%9D%A8%E6%9F%B3%5C%5C%5C%22%7D%7D%5D%7D%2C%5C%5C%5C%22validate%5C%5C%5C%22%3A%7B%5C%5C%5C%22msg%5C%5C%5C%22%3A%5B%5C%5C%5C%22%E8%AF%B7%E5%A1%AB%E5%86%99%E8%81%94%E7%B3%BB%E4%BA%BA%E5%A7%93%E5%90%8D%5C%5C%5C%22%2C%5C%5C%5C%22%E8%81%94%E7%B3%BB%E4%BA%BA%E5%A7%93%E5%90%8D%E4%B8%8D%E5%8F%AF%E9%95%BF%E4%BA%8E10%5C%5C%5C%22%5D%2C%5C%5C%5C%22regex%5C%5C%5C%22%3A%5B%5C%5C%5C%22%5E%5B%5C%5C%5C%5C%5C%5C%5C%5CS%5D%2B%24%5C%5C%5C%22%2C%5C%5C%5C%22%5E%5B%5C%5C%5C%5C%5C%5C%5C%5CS%5D%7B1%2C10%7D%24%5C%5C%5C%22%5D%2C%5C%5C%5C%22fields%5C%5C%5C%22%3A%5B%5C%5C%5C%22value%5C%5C%5C%22%2C%5C%5C%5C%22value%5C%5C%5C%22%5D%7D%2C%5C%5C%5C%22status%5C%5C%5C%22%3A%5C%5C%5C%22hidden%5C%5C%5C%22%7D%7D%5C%22%2C%5C%22linkage%5C%22%3A%5C%22%7B%5C%5C%5C%22common%5C%5C%5C%22%3A%7B%5C%5C%5C%22compress%5C%5C%5C%22%3Atrue%2C%5C%5C%5C%22submitParams%5C%5C%5C%22%3A%5C%5C%5C%22%5E%5E%24%24Z2ae46ca24abb9657d5d3de7628deee184%7C!ali.china.damai%7B%24_%24%7DH4sIAAAAAAAAAO1Ya27cyBG%2ByoBGjF1A5vD9mMAIxiN5V7FHUvTwZhEERJNsanpFsrndTUljw4fIHYLkDgFynCDILfJ1k5yRVyvYQRIgP%2FJnQBarqqurvq76ej5YlSANvePi5ozgSR43XW0tPlhdTVTFRXO57ah%2BL2oi5QlUrYVV8MYmNctJTmwlSEntoma0VXbDS1rbkveioPbZAw%2FvPOvAagfrb0M8c1GylmAl5%2BOB1ZFr%2BtQ6ivCccBtLdrzVa5Rb%2BGGF3VBFHoi1Qk3v7VdX33v22eRw8I2QS9IQhnVLKgu8%2Fu2Pf%2F7HX%2F7097%2F%2BgXQdpA0RN1RBvo%2FycLleHj8M1PUQac0LUusUvN9kqxMLkl5SsZSSXbdfnCVY3DIkqBCUKNZen4qSClvQH3sqlb16KD0fhEMcVBxenkpr8bsPFpPLlrfbhvd4r0gtKSJpGW%2BNryGXL1yTZirespbuLRVtjksd6xjGK%2FZ%2B0HcOLDZ%2BjJw08oIw8aM0ObDkTa8tgiB0HNeJPS9IgwOrIEJpMcxQzGEV%2Fe7GMUyGLV4Mlh%2BQJ3qvXvUSkUiptSxXJ4%2F3xoUVl4lbuQ6Jo6osUlqGcR7naew7VURdGjvYf95vf9OTVjG1xRoItb3dvzs2osjZ%2BxXwB9%2FApl1sgC97KnsneMMV8oM8mDptSNvS%2Bg3dvubiqul0QI7j%2BPgJsBiTr2Hw6408BMgYUDqmWOUr3uR83LZqSF0bwWmnfQ9gRmCAKRfbYSns0hyRiyEjpj67Lwj56F7RVu4ig%2Fo1bakgiiJL47JMnupEHbendYl4GwKomk8fDwCF%2F35BNQY%2BW1DvYUGdiISBT0sn8KLUS%2FIkKOK09H0%2F9tLAjcv%2FF%2FSJgv5%2BfyiqJPf93E2SOE6jOImDtChDnxRxFVbU8dMhh1SscaTQ7wBhSNB%2F2S2dwGeRshT4PKKeDce1Zu3NcvgwIrlkt0xjcDg%2FwNSgyOvSKHwEKulbfs2kYsVo%2BR9w2VJaysmtNCdjB3lBC4qNrKna8HLoT1aroV9rmD19ojZEvmNC9aQ%2BxrnYuSNKCZb3iqJdYpahdU0t6MmzpTFf11ToDHhe6Dph6vjJRxQIrWgQB44bpn4apKlukqwzWzhqSY4MX%2B%2FW3n25ILefyDe86yA4I9sGHWNMKCrZKoh2J9waxqmOu6VKD2o8Igcl1UNkTM3R%2Buzye5T%2F4dTGzF1YZtju56s1jTW5lcjPT6zzsUGPYrkhgsJpMTRLeDPtNBtmpmn6uk3qyBRYwkgOXp%2BfrrPV8vwyu7o4Ood5BZ1X%2FfaE3%2B33pGVmdBS8rZhoTOYuTEymu38yGic5RpbRGBe6I2Z087Kvp7VNYZGbhudMj2kEpjSWrWfqGeuePcs2YeY5rm7x2MQ7KjTo8XknY6PvRvFupDZmn3bes7q0N5q6kI49suwJvKz5e1bXZB7azuwrdrYBX%2FnlbHV2NRueZ6cXM9fNnFnNbuhsTQot%2BO3Xs2UH4vIdzd8wNY%2BcwHZtP5l99ebby%2FXbg0H3G1rc8K9n46pz18UCa7PFuRsu0VNnF6Qigg3mCJHJTxI%2BsBQN5IeIZfKE3u12Mo4a2XcdF%2Bqcgrzh%2FF2J%2FfAbCYou%2BRrp2RdTYgQNQLDAiQBCwbjAnJ7IyzSrLHJHRLkyvAHnULcrqBaamwyQfjwONW0YxuMa1UY9syz7gbM2YyWe4CPPXN9NvSByE893%2FcyFU3xBgyioVqrRswZNJw89kJfEDeM0dEMviuLI8fFCCy8ixqxRGSlvM6pPMDXujTtBW%2FCbTLGG6iX3DhJXf0fUWAmn1lCTnyEfRS8VbzLNFDOpyDYjKhtxnxl0ZfqAas8eOIij2U5brDYouu7HmeI3VIM0CMvEoV6Yh05VuiTIg5wmXhUUnheF1A%2BwkYimaQ5zQSsqBBWw2ijVycV83gxcyC7aOaA%2FL5uKzjfhi75Wgrcv0NLmDLu8tzeqqX%2BFV3MbePmQCGZe9gkFfA4tHOqXSvT0Ob0frg8vf%2BGF8Sv8eN7YNswzfvyledq1kEnurfbySTbqutP7qNM33WroRdOHSXHibpN8NJB9%2FvMGJgooB455QlvYhD%2BxJajZRVczNcn9pY4nPnwuu%2BYl8Xjs2qCVP9BC2WDIdol0mNSDaFKmGaUXOOkiSd1wEQdusnBTv1gkZFElib8ooihd%2BDHxjYnG11F7y1AKPQpge3H4xrN1n5Kmf7lhXqWulwKyRRWkeel7TlHkae4Rn0aBVuwbVl6OULmMckCFxGFEgsT3KhqR2Klct4rgI8njROsDjmbYYLX%2Flc6liQbumcrk3cyE49JM7M%2FyycedQN84P3uveGymT%2FRnmdcjM3MT7EqwdhP1dIfbdUDcpzUP6wW9xB1vRw1215Lh8AxdkMkV73HZvZLoCVNbVrQ74WZi7mwOmSx436rXFHr6%2FjPREjz%2FW5zhbIUcPOAM3xydHJ0v30L4r7AG09mGsfCYH%2BCWfnL6nU71A3KgGwkAoEVPcgPs7Uu4wXAW8XfEnhtA1IKCYIEvnFcajGN4YFImuH8CCQXd1y4RAAA%3D%5C%5C%5C%22%2C%5C%5C%5C%22validateParams%5C%5C%5C%22%3A%5C%5C%5C%22%5E%5E%24%24e58d9c1ba7b12b193039f5875a1d7984%7B%24_%24%7DH4sIAAAAAAAAAIWRXU4CMRSF99Jn0oyDwzC8MQwTeZCQ%2BJP4ZC7tBRo6bdOWKBIW4R6M7sHE5RjjLrwjMfJifOs9uT3n9OuOLTw0eGf9egZ0CpPGaTbYMachLqxvLrcO21loCGFKq2zAhG04aDWHOfDoQSIXWqGJvLESNQ924wXy2ZHDdco6zBxun2V0tl4qA5SU7DvMwRL%2Fyolg52A5RTpr2gy5JR8leIMRjuR2QeM9L69uUj77MTx4U2UJDSjKlRgEje9PL5%2Bvzx9vj%2BAcqQ34NUbSf1tWw%2FPh5LjoSUpNtRWgWwQPq9vRlJGyCeiHIail%2BZ9SWIFHyZ3HQC%2BBqKzhrqXOK4hwTUjl9yccaCHK0QrFekRQ2WABOmCHoRF%2B6%2BJF9MosqUfR7WVlUedZMq7ypMjKPE2yskq6eV1WaV706v64W5enw6Soq964z%2Fb7L7yBoKvzAQAA%5C%5C%5C%22%7D%2C%5C%5C%5C%22signature%5C%5C%5C%22%3A%5C%5C%5C%22cd3f4c2431790228ee5e7f9d23fae26b%5C%5C%5C%22%7D%5C%22%2C%5C%22hierarchy%5C%22%3A%5C%22%7B%5C%5C%5C%22structure%5C%5C%5C%22%3A%7B%5C%5C%5C%22dmPayDetailPopupWindowBlock_1977_window_root%5C%5C%5C%22%3A%5B%5C%5C%5C%22dmPayDetailPopup_1975%5C%5C%5C%22%5D%2C%5C%5C%5C%22dmViewerBlock_DmViewerBlock%5C%5C%5C%22%3A%5B%5C%5C%5C%22dmViewerTitle_1953%5C%5C%5C%22%2C%5C%5C%5C%22dmViewer_1953%5C%5C%5C%22%5D%2C%5C%5C%5C%22dmContactBlock_DmContactBlock%5C%5C%5C%22%3A%5B%5C%5C%5C%22dmContactTitle_1965%5C%5C%5C%22%2C%5C%5C%5C%22dmContactName_1966%5C%5C%5C%22%2C%5C%5C%5C%22dmContactEmail_1968%5C%5C%5C%22%2C%5C%5C%5C%22dmContactPhone_1967%5C%5C%5C%22%5D%2C%5C%5C%5C%22dmItemBlock_DmItemBlock%5C%5C%5C%22%3A%5B%5C%5C%5C%22dmItemInfo_1950%5C%5C%5C%22%2C%5C%5C%5C%22dmTicketsInfo_1951%5C%5C%5C%22%5D%2C%5C%5C%5C%22order_f8b33b188779678749cd53ac7f5fe039%5C%5C%5C%22%3A%5B%5C%5C%5C%22item_7d81f10a76fdc9ed57b7b9730f6e1e70%5C%5C%5C%22%2C%5C%5C%5C%22item_06a543ed0426928b84c79d333729417d%5C%5C%5C%22%5D%2C%5C%5C%5C%22dmDeliveryWayBlock_DmDeliveryWayBlock%5C%5C%5C%22%3A%5B%5C%5C%5C%22dmDeliverySelectCard_1955%5C%5C%5C%22%2C%5C%5C%5C%22dmDeliveryTip_1956%5C%5C%5C%22%2C%5C%5C%5C%22dmDeliveryAddress_1957%5C%5C%5C%22%2C%5C%5C%5C%22dmDeliveryFee_1959%5C%5C%5C%22%2C%5C%5C%5C%22dmDeliveryMachineAddress_1961%5C%5C%5C%22%2C%5C%5C%5C%22dmDeliveryTicketAddress_1962%5C%5C%5C%22%5D%2C%5C%5C%5C%22confirmOrder_1%5C%5C%5C%22%3A%5B%5C%5C%5C%22dmTopNotificationBlock_DmTopNotificationBlock%5C%5C%5C%22%2C%5C%5C%5C%22dmItemBlock_DmItemBlock%5C%5C%5C%22%2C%5C%5C%5C%22dmViewerBlock_DmViewerBlock%5C%5C%5C%22%2C%5C%5C%5C%22dmDeliveryWayBlock_DmDeliveryWayBlock%5C%5C%5C%22%2C%5C%5C%5C%22dmContactBlock_DmContactBlock%5C%5C%5C%22%2C%5C%5C%5C%22order_f8b33b188779678749cd53ac7f5fe039%5C%5C%5C%22%2C%5C%5C%5C%22dmInvoiceBlock_DmInvoiceBlock%5C%5C%5C%22%2C%5C%5C%5C%22dmPayTypeBlock_DmPayTypeBlock%5C%5C%5C%22%2C%5C%5C%5C%22dmOrderSubmitBlock_DmOrderSubmitBlock%5C%5C%5C%22%2C%5C%5C%5C%22dmEttributesHiddenBlock_DmAttributesBlock%5C%5C%5C%22%5D%2C%5C%5C%5C%22dmOrderSubmitBlock_DmOrderSubmitBlock%5C%5C%5C%22%3A%5B%5C%5C%5C%22dmProtocol_1976%5C%5C%5C%22%2C%5C%5C%5C%22dmSubmit_1977%5C%5C%5C%22%5D%2C%5C%5C%5C%22dmPayTypeBlock_DmPayTypeBlock%5C%5C%5C%22%3A%5B%5C%5C%5C%22dmPayTypeTitle_1972%5C%5C%5C%22%2C%5C%5C%5C%22dmPayType_1972%5C%5C%5C%22%5D%2C%5C%5C%5C%22deliveryMethodOptions_f8b33b188779678749cd53ac7f5fe039%5C%5C%5C%22%3A%5B%5C%5C%5C%22deliveryMethodPopupTitle_f8b33b188779678749cd53ac7f5fe039%5C%5C%5C%22%2C%5C%5C%5C%22deliveryMethodOption_f8b33b188779678749cd53ac7f5fe039_0%7C2%5C%5C%5C%22%2C%5C%5C%5C%22deliveryMethodPopupConfirm_f8b33b188779678749cd53ac7f5fe039%5C%5C%5C%22%5D%2C%5C%5C%5C%22dmTopNotificationBlock_DmTopNotificationBlock%5C%5C%5C%22%3A%5B%5C%5C%5C%22dmTopNotification_1948%5C%5C%5C%22%5D%7D%7D%5C%22%7D%22%2C%22feature%22%3A%22%7B%5C%22subChannel%5C%22%3A%5C%22damai%40damaih5_h5%5C%22%2C%5C%22wxOpenId%5C%22%3A%5C%22%5C%22%2C%5C%22returnUrl%5C%22%3A%5C%22https%3A%2F%2Fm.damai.cn%2Fdamai%2Fpay-success%2Findex.html%3Fspm%3Da2o71.orderconfirm.bottom.dconfirm%5C%22%2C%5C%22umidToken%5C%22%3A%5C%22T3AFA6B68F4F19C5F4DE72CBD2F0188A54AB501C97A79EB3AE505A9AA87%5C%22%7D%22%2C%22ua%22%3A%22122%237QpSsDXpEEJXhJpZy4pjEJponDJE7SNEEP7rpJRBuDPpJFQLpCGwoHZDpJEL7SwBEyGZpJLlu4Ep%2BFQLpoGUEELWn4yE7SNEEP7ZpERBuDPE%2BBQPpC76EJponDJyKMQExa0UGEnTbUVFRiLVWUtILdfzJHd61cqkkkCdqtznpi3NsXgFrXeOyTBkQNNeU%2F38W9rliuXNs09laMXv9kswETJtbjqZSwiPawk5Ya%2BX7c8B8oL6JyIEBkUR0MfbD5oMnTl1B4IEDtVZ8CL6J4EEyBfDqWv2EEpadBZ9kxgbELVrtFpUJDEbyo3mqW32E5pangL4ul0EDtVZ8CL6JNEEyBfDqMf2DEpxnSp1uOIEbIhr8CpKaEbEyCfG7SXbEEpKf4XxHyyPfJaC%2FYk6GRkbyKNkirNyAKcL%2F4zK5YCPt8u26pazhaJ1CH9MKlYMTPKJPkdPBt0S0d8c9CUfsI3IAnkr5HHtAjo8I8TWPNSRn5KzBrUAoMC335NL2ER6EZbRO%2BYqU3cqWuFAaFDavQwwBEcrkTq8dSWKzcpdNl%2Fz4XHrwU5uKnQK%2B9sCiwdB0xQ%2BpjvyMdsccj8PGUUtOYPck4giIRaEEiZWaj6qCpMdEFlOxACVyQVE%2FVr4qGLbW2u8LgTRMjc%2FGgtCJH270WEzALr9mnZM3NndkCtRqwd%2FTneDVtJww3WCH%2F0%2FjoMDV1UsH89eR5kXWCidGCWZnARVqLFts1jMwdwCz449df49EqQeM8fraxXEUMEj2AbdkkhV4ZE9wcOQiMAyiKRaUIJTFq9mN%2B3IS7Q%2Fdq4viUGWeAcPPPhRVz8RkniY1TcQvgxZsnZQ8PVxcEjMwQvVn7jPGqPbNwv8riP9DwiK%2F%2Bvg60WQ%2Fjo0N3hvpR1LOSX2UDj%2F%2Fp2badymhCbwgGvp1AfHPLoPEzK8TkTNJdPXpjoh%2BXsr2J9U8E6qLPFWyJp1Ev%2B0v7ZqkIRjvQvz3NsR5gYvO8GIPGBucJw42eKXgwYBRUYeOxabFxu%2FOTG00y3NpYKbmDATardhJJ3W6zFvBiAebzFfmUC%2BLch1mUGW3Ny99YXGBARw8372tG%2BSvd5x4qOKkArntxqhbX3msTGcLas%2F3UxGq7XU8Q%2Ft%2BOeXTy8%3D%22%7D&ua=122%23uUmSEE0TEExhk4pZy4pjEJponDJE7SNEEP7rpJRBuDPpJFQLpCGwoHZDpJEL7SwBEyGZpJLlu4Ep%2BFQLpoGUEELWn4yE7SNEEP7ZpERBuDPE%2BBQPpC76EJponDJyKMQExa0UGEnTbUVFRiLVWUtILdfzJHd61cqkkkCdqtznpi3NsXgFrXeOyTBkQNNeU%2F38W9rliuXNs09laMXv9kswETJtbjqZSwiPawk5Ya%2BXqcCh8oL6JPIEBkfDqMfEJN2njSplul5EELXr8CL6JNbERF3mqM3okBTlpM%2B1ul9rDLVZ8CRfJ4bEyF3mqW32E5pangLlul5EELXZ8oL6JNEEyB3DqMfbDEpxnSpmtP0EDL348CpNJmc2MFfmqRid0%2BoPdMSSp5%2BscjftM0VaIKjrimxSs5C92m0%2F7tfJAXmtFLrNZ2cK9XSazOPSeJtAePM%2FMj7bMt5tUmTHWJLxVxwyCSHMfVqGHMxs%2BuSXvZ%2Bk2D8fnQVZZ%2BO8Z2N0qNzL0pE2RP6daCtBFSrQBFve9BQWH%2Br3IyMtmFX4n78alCdbWqwCrd7%2FOusLhvgCYdfrBtBtHcoJXLDAY2M9exGzUlMCx0u7eADHNyR2c2o05FkOexnGrwK1TbzmCVB5cdl4C515ztlPvE7ACtzb84ENynhsD8eziK36x9377FirlV1L7mmO%2FNmJZtyOQuHnyrjoRGBMQTl7%2FPw3MuYFYH58YXtObbXpWjoCMyJpjoTct0JI6rbc0uGD0TXcgAsFZHtLlqHp%2BJ70VkonmjU6T5oaO53Giuz9lYAEauFy6eMWdh75XqmPiRyBI3Fju7nyPY7KWg4eI8z%2FRNAxJR06Qkqk67e%2BQIxIF2UIvBedksna8%2F2AlHfRvWwvvi5W7S%2F5COAIworAQE5IVVX9e2jfBhloPEqaaiondfqr7%2Bjba%2F7p3VK%2BDkucIZqHMRjqjpgdbKZDEOmFEplD8QOzR9s%2BEQUkofPudMLXgEqVOB4klzjjsbV67u49%2Bfx%2FmgwL1MsebZvr3oppJq7nI7%2Bvp21ktWniyBnbf5eF2PT1PJHrcrsZhkZtBPOHDtnFxDtmWIq%2FRV86Z2zOmy6fmnULcWVQLHYCnNUU3G%2Bh6dlFmu2fldq%3D";
        com.rqm.tool.http.HttpUtils.doHttp(path,cookies,"POST",param);

    }
}