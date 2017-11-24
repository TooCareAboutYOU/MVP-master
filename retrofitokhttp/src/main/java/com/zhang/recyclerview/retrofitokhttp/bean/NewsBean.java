package com.zhang.recyclerview.retrofitokhttp.bean;

import java.util.List;

/**
 * Created by zs on 2017/11/23.
 */

public class NewsBean {


    /**
     * programs : [{"title":"孙耀威曝秘密结婚 情定长跑8年港星女友？","nodeId":"","detail":"据台湾媒体报道，香港男星孙耀威现年44岁，与36岁女友陈美诗爱情长跑8年，2016年传出秘婚消息\u2026","link":"banner","image":"http://yweb3.cnliveimg.com/img/cnlive/170515145749804_613.jpg","type":"ylsd","contId":"625546641"},{"title":"《林子大了》将播 郭麒麟：希望影视上超越郭德纲","nodeId":"","detail":"3月30日，《林子大了》在北京德云社举办首播发布会。郭麒麟表示，希望影视上超越郭德纲\u2026","link":"banner","image":"http://yweb2.cnliveimg.com/img/cnlive/170515145734097_668.jpg","type":"ylsd","contId":"625546992"},{"title":"王思聪遇徐静蕾露憨笑 这表情有点醉","nodeId":"","detail":"某电影在北京师范大学进行点映，王思聪现身电影剧场观看电影，表情不断，十分搞怪\u2026","link":"banner","image":"http://yweb0.cnliveimg.com/img/cnlive/170515145707103_611.jpg","type":"ylsd","contId":"625548938"},{"title":"小鱼儿现搞笑七秒记忆 淡定妈胡可放手育儿法获赞","nodeId":"","detail":"近日，某亲子节目第一期正式上线，节目中小鱼儿现搞笑七秒记忆，淡定妈胡可放手育儿法获赞\u2026","link":"banner","image":"http://yweb1.cnliveimg.com/img/cnlive/170515145713043_880.jpg","type":"ylsd","contId":"625550247"},{"title":"又来撒糖了！ 杨幂赵又廷合体拍摄杂志大片","nodeId":"","detail":"自从三生三世火热播出后，杨幂赵又廷两人关系瞬间被网友炒的火热，最近，他们又合体杂志大片\u2026","link":"banner","image":"http://yweb0.cnliveimg.com/img/cnlive/170515145616794_713.jpg","type":"ylsd","contId":"625544290"},{"title":"胡杏儿自曝超羡慕孙俪 袁伟豪否定胡定欣有情伤","nodeId":"","detail":"胡杏儿和袁伟豪今天出席意大利时装品牌，在香港首间分店的开幕礼，杏儿表示迫不及待进去血拼\u2026","link":"banner","image":"http://yweb2.cnliveimg.com/img/cnlive/170515145550782_022.jpg","type":"ylsd","contId":"625543297"},{"title":"张翰法国巴黎独自狂购 却发生如此尴尬的事","nodeId":"","detail":"今日，有网友在巴黎偶遇了正在购物的张翰。此时的张翰身边不仅少了古力娜扎的影子，还发生了意想不到尴尬的一幕\u2026","link":"cont","image":"http://yweb0.cnliveimg.com/img/cnlive/170515142426919_423.jpg","type":"ylsd","contId":"625470106"},{"title":"杨洋首谈\u201c小戏疯子\u201d称号 重返银幕吴尊大呼\u201c过瘾\u201d","nodeId":"","detail":"3月25日，电视剧《武动乾坤》在象山举办媒体探班活动，主演杨洋、吴尊、张天爱、王丽坤穿着戏服接受众媒体采访。","link":"cont","image":"http://yweb1.cnliveimg.com/img/cnlive/170515142446354_371.jpg","type":"ylsd","contId":"625470126"},{"title":"Angelababy强势回归跑男 迪丽热巴何去何从？","nodeId":"","detail":"近日，有消息称baby将会在第八期回归《奔跑吧》，迪丽热巴只是代跑，节目组貌似想让baby产后回归\u2026","link":"cont","image":"http://yweb2.cnliveimg.com/img/cnlive/170515142506329_423.jpg","type":"ylsd","contId":"625473375"},{"title":"黄日华透露刘德华伤势 华仔康复进展很好","nodeId":"","detail":"首批香港出生的七只导盲犬将投入服务,黄日华特地放下工作前来支持，被问到华仔的伤势，他表示进展良好\u2026","link":"cont","image":"http://yweb3.cnliveimg.com/img/cnlive/170515142525634_007.jpg","type":"ylsd","contId":"625543104"},{"title":"黄晓明给儿子取名\u201c小海绵\u201d 寓意非同一般","nodeId":"","detail":"小海绵这个昵称挺有意思，angelababy微博发过何时能享受属于我的海绵蛋糕，海绵蛋糕是小明粤语谐音\u2026","link":"cont","image":"http://yweb0.cnliveimg.com/img/cnlive/170515142548804_278.jpg","type":"ylsd","contId":"625541585"},{"title":"3岁就爱美！ 黄磊女儿多妹与小闺蜜结伴涂指甲油","nodeId":"","detail":"3月29日，黄磊老婆晒出二女儿多妹与小闺蜜一起涂抹指甲油的照片，多妈感慨道：\u201c天性。\u201d\u2026","link":"cont","image":"http://yweb1.cnliveimg.com/img/cnlive/170515142622252_573.jpg","type":"ylsd","contId":"625542767"}]
     * lottery_url : 查询列表成功
     * errorCode : 0
     */

    private String lottery_url;
    private String errorCode;
    private List<ProgramsBean> programs;

    public String getLottery_url() {
        return lottery_url;
    }

    public void setLottery_url(String lottery_url) {
        this.lottery_url = lottery_url;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public List<ProgramsBean> getPrograms() {
        return programs;
    }

    public void setPrograms(List<ProgramsBean> programs) {
        this.programs = programs;
    }

    public static class ProgramsBean {
        /**
         * title : 孙耀威曝秘密结婚 情定长跑8年港星女友？
         * nodeId :
         * detail : 据台湾媒体报道，香港男星孙耀威现年44岁，与36岁女友陈美诗爱情长跑8年，2016年传出秘婚消息…
         * link : banner
         * image : http://yweb3.cnliveimg.com/img/cnlive/170515145749804_613.jpg
         * type : ylsd
         * contId : 625546641
         */

        private String title;
        private String nodeId;
        private String detail;
        private String link;
        private String image;
        private String type;
        private String contId;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getNodeId() {
            return nodeId;
        }

        public void setNodeId(String nodeId) {
            this.nodeId = nodeId;
        }

        public String getDetail() {
            return detail;
        }

        public void setDetail(String detail) {
            this.detail = detail;
        }

        public String getLink() {
            return link;
        }

        public void setLink(String link) {
            this.link = link;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getContId() {
            return contId;
        }

        @Override
        public String toString() {
            return "ProgramsBean{" +
                    "title='" + title + '\'' +
                    ", nodeId='" + nodeId + '\'' +
                    ", detail='" + detail + '\'' +
                    ", link='" + link + '\'' +
                    ", image='" + image + '\'' +
                    ", type='" + type + '\'' +
                    ", contId='" + contId + '\'' +
                    '}';
        }

        public void setContId(String contId) {
            this.contId = contId;

        }

    }

    @Override
    public String toString() {
        return "{" +
                "lottery_url='" + lottery_url + '\'' +
                ", errorCode='" + errorCode + '\'' +
                ", programs=" + programs +
                '}';
    }
}
