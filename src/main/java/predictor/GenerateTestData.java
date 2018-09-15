package predictor;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

class GenerateTestData {

    public static void main(String [] args) throws FileNotFoundException, UnsupportedEncodingException {

        //Start and End Date determine the period of training data
        Date startDate = new Date();
        final long hoursInMillis = 60L * 60L * 1000L;
        Date endDate = new Date(startDate.getTime() + (1L * hoursInMillis)); // Adds 2 hours to start date

        PrintWriter writer = new PrintWriter("service.information.csv", "UTF-8");
        writer.println("calleeService,serviceCallingDate,serviceDelay,responseCode,amount_service_parameter,callerService");

        for(int i = 0; i < 6000; i++) {//total = max_i * max_j
            String testData = randomInputGenerator(startDate, endDate);
            for(int j=0; j < 20; j++) //repetition
                writer.println(testData);
        }
        writer.close();
    }

    public static String randomInputGenerator(Date startDate, Date endDate){
        StringBuffer inputEntry = new StringBuffer();

        //Callee Service (max of services : 20)
        Random randName = new Random(); //among 20 services
        int  serviceName = randName.nextInt(20) + 1;
        inputEntry.append(Integer.toString(serviceName));

        //Service Calling Date
        long random = ThreadLocalRandom.current().nextLong(startDate.getTime(), endDate.getTime());
        Date date = new Date(random);
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd'T'hhmmss");
        inputEntry.append(',' + format.format(date));

        //Service Delay (maximum : 5 second)
        Random randDuration = new Random(); //millisecond
        int  duration = randDuration.nextInt(5000) + 1;
        inputEntry.append(',' + Integer.toString(duration));

        //Response Code (1 : success / 2 : failed)
        Random randResponseCode = new Random(); // 1:ok 2:not_ok
        int  responseCode = randResponseCode.nextInt(2) + 1;
        inputEntry.append(',' + Integer.toString(responseCode));

        //Amount (Service Parameter: max : 1000)
        Random randAmount = new Random();
        int  amount = randAmount.nextInt(1000) + 1;
        inputEntry.append(',' + Integer.toString(amount));

        //Caller Service (max of services : 20)
        Random randCallerModule = new Random();
        int  callerModule = randCallerModule.nextInt(20) + 1;
        inputEntry.append(',' + Integer.toString(callerModule));

        return inputEntry.toString();
    }
}
