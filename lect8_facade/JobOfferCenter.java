package lect8_facade;
// We use FACADE pattern when the client just want to use a method and they don't care about the complicated logic 
// of the classes that the whole system works.

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

//in other words, if we want to "hide" the complexity of the system, we use the Facade pattern.

class Company{
    public String Tempting_to_hire(){
        return "Tempting to hire";
    }
    public String sayYes(){
        return "yes";
    }
    public String sayNo(){
        return "no";
    }
    public String giveAnswertoApplication(String application){
        System.out.println("Company's answer to Application: " + application);
        int interviewer_luck = ThreadLocalRandom.current().nextInt()%2; 
        if(interviewer_luck == 0){
            return sayYes();
        }
        else{
            return sayNo();
        }
    }
}
class JobOffer_Receptionist{
    private Boolean job_Available_Status = false;
    private Company contacted_Company = new Company();

    public void contact_to_Companies(){
        String attemp_of_company = contacted_Company.Tempting_to_hire();
        if(attemp_of_company.equals("Tempting to hire")){
            job_Available_Status = true;
        }
    }
    public void deal_with_Candidate_Application(String application){
        System.out.println("Receive Candidate Application: " + application);
        String answer = contacted_Company.giveAnswertoApplication(application);
        System.out.println("Company's answer " + answer);
    }
    
}
class JobOfferCenter_FACADE{
    private JobOffer_Receptionist jobOffer_Receptionist = new JobOffer_Receptionist();
    private Boolean askForFee(){
        System.out.println("The fee is 100$");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Do you want to pay the fee? (yes/no)");
        String answer = scanner.nextLine();
        if(answer.equals("yes")){
            return true;
        }
        else{
            return false;
        } 
    }
    public void findJob(String application){
        if(askForFee() == false){
            System.out.println("Okay, we will not find you a job");
        }
        else{
            jobOffer_Receptionist.contact_to_Companies();
            jobOffer_Receptionist.deal_with_Candidate_Application(application);
        }
    }
}
class Client{
    public static void main(String[] args){
        JobOfferCenter_FACADE jobOfferCenter_FACADE = new JobOfferCenter_FACADE();
        Scanner newScanner = new Scanner(System.in);
        System.out.println("Enter your application: ");
        String application = newScanner.nextLine();
        jobOfferCenter_FACADE.findJob(application);
    }
}
