package com.num.beans;
import com.num.util.GetUpTime;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class ServerStatus implements Serializable{
    List<String> top;
    String system_date_time;
    String uptime;
    public ServerStatus(){

        // get system date time
        system_date_time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());

        try {
            // get system uptime
            uptime = sysUpTime();
        } catch (Exception ex) {
            Logger.getLogger(ServerStatus.class.getName()).log(Level.SEVERE, null, ex);
            uptime = "Error getting uptime";
        }

        // get top command output       
        top = readTopCommandOut();
    }

    private String sysUpTime() throws Exception{
        long upTime = GetUpTime.getSystemUptime();
        //System.out.println("up time: " + upTime + " ms");
        //System.out.println("up time: " + TimeUnit.DAYS.convert(upTime, TimeUnit.MILLISECONDS) + " days");
        long days = TimeUnit.DAYS.convert(upTime, TimeUnit.MILLISECONDS);
        String strLong = Long.toString(days);
        return strLong;
        }
    
    private ArrayList<String> readTopCommandOut(){
    
        ArrayList<String> arr = new ArrayList<String>();
       String top_out_file = "/tmp/top_out_file.dat";
        /*
        Note: 
        File top_out_file.dat is populated using bash script num_mon_data.sh
        every 5 seconds.
        */
        //String top_out_file = "C:\\Users\\User01\\Desktop\\top_out_file.dat";
        try (BufferedReader br = new BufferedReader(new FileReader(top_out_file)))
        {

            String sCurrentLine;

            while ((sCurrentLine = br.readLine()) != null) {
                arr.add(sCurrentLine);
            }

        } catch (IOException e) {
            arr.add("Error reading file " + top_out_file);
        }     
        
        return arr;    
    }
    
    // setters
    public List<String> getTop() {
        return top;
    }

    public String getSystem_date_time() {
        return system_date_time;
    }

    public String getUptime() {
        return uptime;
    }    
}
