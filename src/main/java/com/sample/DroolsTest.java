package com.sample;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

/**
 * This is a sample class to launch a rule.
 */
public class DroolsTest {

    public static final void main(String[] args) {
        try {
            // load up the knowledge base
	        KieServices ks = KieServices.Factory.get();
    	    KieContainer kContainer = ks.getKieClasspathContainer();
        	KieSession kSession = kContainer.newKieSession("ksession-rules");

            // go !
            Message message = new Message();
            message.setMessage("Hello World");
            message.setStatus(Message.HELLO);
            kSession.insert(message);
            
            Person person = new Person();
            person.setAge(20);
            person.setSallery(100000);
            person.setSsn("03086529520");
            kSession.insert(person);
            
            Customer customer = new Customer();
            customer.setSsn("03086529520");
            kSession.insert(customer);
            
            kSession.fireAllRules();
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }
    
    public static class Person {
    	private int age;
        private int sallery;
        private String ssn;
        private String teksten;
    
        public String getTeksten() {
			return teksten;
		}
		public void setTeksten(String teksten) {
			this.teksten = teksten;
		}
		public static final int TO_MUCH_SALLERY = 100000;
        
        public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}
		public int getSallery() {
			return sallery;
		}
		public void setSallery(int sallery) {
			this.sallery = sallery;
		}
		public String getSsn() {
			return ssn;
		}
		public void setSsn(String ssn) {
			this.ssn = ssn;
		}
    }
    
    public static class Customer {
    	  private String ssn;
    	  private int inncome;
		public String getSsn() {
			return ssn;
		}
		public void setSsn(String ssn) {
			this.ssn = ssn;
		}
		public int getInncome() {
			return inncome;
		}
		public void setInncome(int inncome) {
			this.inncome = inncome;
		}
    	  
    	  
    }

    public static class Message {

        public static final int HELLO = 0;
        public static final int GOODBYE = 1;

        private String message;

        private int status;

        public String getMessage() {
            return this.message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public int getStatus() {
            return this.status;
        }

        public void setStatus(int status) {
            this.status = status;
        }
    }

}
