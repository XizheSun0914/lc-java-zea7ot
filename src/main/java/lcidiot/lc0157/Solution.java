package main.java.lcidiot.lc0157;

import main.java.lcidiot.utils.Reader4;

public class Solution extends Reader4{
    public int read(char[] buf, int n) {
        char[] buffer = new char[4];
        int idx = 0;
        
        while(true){
            int count = read4(buffer);
            
            // to get the actual count
            // Even if we read 4 chars from Read4,  
            // we don't want to exceed N and only want to read chars till n 
            count = Math.min(count, n - idx);
            
            // to copy from buffer to buf
            for(int i = 0; i < count; i++){
                buf[idx++] = buffer[i];
            }
            
            if(count != 4) return idx;
        }
    }
}