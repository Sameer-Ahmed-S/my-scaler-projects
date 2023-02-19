package org.scaler;

import java.time.LocalDateTime;

public interface Lib {

    /**
     * Returns "Good Morning" if the hour is before 12,
     * "Good Afternoon" if the hour is before 18,
     * and "Good Evening" otherwise.     *
     */
    static String getGreeting()
    {
        LocalDateTime dateTime= LocalDateTime.now();
        int hour=dateTime.getHour();

        if(hour<12)
        {
            return "Good Morning";
        }
        else if(hour<18)
        {
            return "Good Afternoon";
        }
        else
        {
            return "Good Evening";
        }
    }
}
