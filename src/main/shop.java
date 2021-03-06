package main;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class shop {
    ArrayList<animal> animalList = new ArrayList<>();
    int animalCount = 0;
    DateFormat df = new SimpleDateFormat("yyyy-MM-dd", Locale.UK);

    public shop() {
    }

    void addAnimal(String[] parameters) {
        String animalType = parameters[1];
        animalCount += 1;
        switch (animalType) {
            case "Dog":
                animalList.add(new dog(parameters));
                break;
            case "Cat":
                animalList.add(new cat(parameters));
                break;
            case "Rabbit":
                animalList.add(new rabbit(parameters));
                break;
            case "Golden Hamster":
                animalList.add(new goldenHamster(parameters));
                break;
            case "Roborovski Hamster":
                animalList.add(new roborvskiHamster(parameters));
                break;
            case "Guinea Pig":
                animalList.add(new guineaPig(parameters));
                break;
            case "Edward's Fig Parrot":
                animalList.add(new figParrot(parameters));
                break;
            case "Norwegian Blue":
                animalList.add(new norwegianBlue(parameters));
                break;
            case "Hyacinth Macaw":
                animalList.add(new hyacinthMacaw(parameters));
                break;
            case "Yellow Canary":
                animalList.add(new yellowCanary(parameters));
                break;
            case "Goldfish":
                animalList.add(new goldfish(parameters));
                break;
            case "Koi":
                animalList.add(new koi(parameters));
                break;
            case "Common Barbel":
                animalList.add(new barbel(parameters));
                break;
            case "Boa Constrictor":
                animalList.add(new boaConstrictor(parameters));
                break;
            case "Corn Snake":
                animalList.add(new cornSnake(parameters));
                break;
            case "Black-necked Spitting Cobra":
                animalList.add(new spittingCobra(parameters));
                break;


        }    //string/array inputs are of form [givenName, commonName, price, sex, colour, arrivalDate, sellingDate]
    }

    public Calendar strToDate(String dateIn) {
        //input must be in string format "YYYY-MM-DD"
        String[] ds = dateIn.split("-");
        Calendar outDate = Calendar.getInstance();
        outDate.set(Integer.parseInt(ds[0]), (Integer.parseInt(ds[1]) - 1), Integer.parseInt(ds[2]));
        return outDate;
    }

    public String dateToStr(Calendar dateIn) {
        String outStr = (df.format(dateIn.getTime()));
        return outStr;
    }

    public String discount(String price, String arrDate) {//calculates the price of an animal that's entered into the
        //system based on their arrival date and the discount brackets
        int arrMonth = Integer.parseInt((arrDate.split("-"))[1]);
        int arrDay = Integer.parseInt((arrDate.split("-")[2]));
        int arrYear = Integer.parseInt((arrDate.split("-")[0]));
        Calendar cal = Calendar.getInstance();
        Date today = new Date();
        cal.setTime(today);
        int currentMonth = cal.get(Calendar.MONTH) + 1;
        int currentDay = cal.get(Calendar.DAY_OF_MONTH);
        int currentYear = cal.get(Calendar.YEAR);
        float initPrice = Float.parseFloat(price);
        double finalPrice;
        if(arrYear < (currentYear-1)){//if the year is at least two out, max discount applied
            finalPrice = Math.floor(initPrice * 0.8 * 100)/100;
        }else if(arrYear == (currentYear-1)){//handles crossover between years
            int b =currentMonth + (12 - arrMonth);//calculate difference in months between years, i.e.
            //feb 2018 compared to nov 2017 would be 2 + (12 - 11) = 3 months
            if((b < 2) || b == 2 && arrDay > currentDay){
                finalPrice = Math.floor(initPrice * 100)/100;
            }else if((b < 4) || (b == 4 && arrDay > currentDay)){
                finalPrice = Math.floor(initPrice * 0.9 * 100) / 100;
            }else{
                finalPrice = Math.floor(initPrice * 0.8 * 100) / 100;
            }
        }
        else {
            int mon = currentMonth - arrMonth;
            if ((mon < 2) || (mon == 2 && arrDay > currentDay)) {
                finalPrice = Math.floor(initPrice*100)/100;
            } else if ((mon < 4) || (mon == 4 && arrDay > currentDay)) {
                finalPrice = Math.floor(initPrice * 0.9 * 100) / 100;
            } else {
                finalPrice = Math.floor(initPrice * 0.8 * 100) / 100;
            }
        }
        return Double.toString(finalPrice);
    }

    public ArrayList<String> classLister(int type) {
        int x = type;
        ArrayList<String> outList = new ArrayList<>();
        switch (x){
            case 0: for (int i = 0; i < animalList.size(); i++) {
                String cl = animalList.get(i).getAClass();
                if (!(outList.contains(cl))) {
                    outList.add(cl);
                }}
                break;
            case 1: for (int i = 0; i < animalList.size(); i++) {
                String cl = animalList.get(i).getOrder();
                if (!(outList.contains(cl))) {
                    outList.add(cl);
                }}
                break;
            case 2: for (int i = 0; i < animalList.size(); i++) {
                String cl = animalList.get(i).getFamily();
                if (!(outList.contains(cl))) {
                    outList.add(cl);
                }}
                break;
            case 3: for (int i = 0; i < animalList.size(); i++) {
                String cl = animalList.get(i).getGenus();
                if (!(outList.contains(cl))) {
                    outList.add(cl);
                }}
                break;
            case 4: for (int i = 0; i < animalList.size(); i++) {
                String cl = animalList.get(i).getSpecies();
                if (!(outList.contains(cl))) {
                    outList.add(cl);
                }}
                break;
            case 5: for (int i = 0; i < animalList.size(); i++){
                String c1 = animalList.get(i).getCommonName();
                if(!(outList.contains(c1))) {
                    outList.add(c1);
                }}
                break;
            case 6: for (int i = 0; i< animalList.size(); i++){
                String c1 = animalList.get(i).getColour();
                if(!(outList.contains(c1))) {
                    outList.add(c1);
                }}
                break;

        }
        return outList;
    }


}







