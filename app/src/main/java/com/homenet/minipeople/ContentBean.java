package com.homenet.minipeople;

import java.util.List;

/**
 * Created by weijunpeng on 2018/1/6.
 */

public class ContentBean {
    private List<Manmsg> manmsgs;

    public List<Manmsg> getManmsgs() {
        return manmsgs;
    }

    public void setManmsgs(List<Manmsg> manmsgs) {
        this.manmsgs = manmsgs;
    }

    public class Manmsg {
        private int item;
        private String content;

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public int getItem() {

            return item;
        }

        public void setItem(int item) {
            this.item = item;
        }
    }
}
