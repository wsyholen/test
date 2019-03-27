package com.holen.model;

import java.util.Date;

/**
 * <pre>
 * 说    明:
 * 涉及版本: V1.0.0
 * 创 建 者: Holen
 * 日    期: 2018/12/4 11:13
 * 联系方式: 317776764
 * </pre>
 */
public class User {

        private long id;
        private String email;
        private String password;
        private String username;
        private String role;
        private int status;
        private Date regTime;
        private String regIp;

        public long getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getRole() {
            return role;
        }

        public void setRole(String role) {
            this.role = role;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public Date getRegTime() {
            return regTime;
        }

        public void setRegTime(Date regTime) {
            this.regTime = regTime;
        }

        public String getRegIp() {
            return regIp;
        }

        public void setRegIp(String regIp) {
            this.regIp = regIp;
        }

}
