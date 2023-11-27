package com.abhishek.SocialMediaApp.HelloWorld;
public class HelloWorldBean {
        private String message;

        public HelloWorldBean(String message) {
            super();
            this.message=message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }


        @Override
        public String toString() {
            return "HelloWorldBean{" +
                    "message='" + message + '\'' +
                    '}';
        }
    }

