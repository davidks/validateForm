import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ValidateForm
{
   public static void main(String[] args)
   {
      EventQueue.invokeLater(new Runnable()
         {
            public void run()
            {
               TextComponentFrame frame = new TextComponentFrame();
               frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               frame.setVisible(true);
            }
         });
   }
}

/**
 * A frame with sample text components.
 */
class TextComponentFrame extends JFrame
{
   public TextComponentFrame()
   {
      setTitle("Subscription Form");
      setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

      final JTextField personName = new JTextField();
      final JTextField emailField = new JTextField();
      final JTextField zipCode = new JTextField();
      final JTextField birthDate = new JTextField();
      final JTextField phone= new JTextField();
      final JPasswordField passwordField = new JPasswordField();
      
      
      JPanel northPanel = new JPanel();
      northPanel.setLayout(new GridLayout(6, 6)); //dimensons of layout
      northPanel.add(new JLabel("Name :  ", SwingConstants.RIGHT));
      northPanel.add(personName);
      
      northPanel.add(new JLabel("Password :  ", SwingConstants.RIGHT));
      northPanel.add(passwordField);
      
      
      northPanel.add(new JLabel("Email : ", SwingConstants.RIGHT));
      northPanel.add(emailField);
      northPanel.add(new JLabel("Zip Code : ", SwingConstants.RIGHT));
      northPanel.add(zipCode);
      northPanel.add(new JLabel("Year of Birth: ", SwingConstants.RIGHT));
      northPanel.add(birthDate);
      northPanel.add(new JLabel("Phone Number: ", SwingConstants.RIGHT));
      northPanel.add(phone);
      phone.setText("XXX-XXX-XXX");       

      add(northPanel, BorderLayout.NORTH);

      final JTextArea textArea = new JTextArea(8, 40);
      JScrollPane scrollPane = new JScrollPane(textArea);

      add(scrollPane, BorderLayout.CENTER);

      // add button to append text into the text area

      JPanel southPanel = new JPanel();

      JButton insertButton = new JButton("Insert");
      southPanel.add(insertButton);
      insertButton.addActionListener(new ActionListener()
         {
             //methods
             private boolean passCheck(String str)
             {
                 if(str.length()<4)
                 {
                     return false;
                 }
                 //FINISH
                 
                return true;
                 
             }
             private boolean isAllAlpha(String input)
             {
                 if(input.length()<1)

                 {
                     return true;
                    }
                 
                    String master = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM";
                    for(int i = 0; i<input.length();i++)
                    {
                        String letter = input.substring(i,i+1);
                    if(master.indexOf(letter) == -1)
                    {
                        return false;
                    }
                    
                    if(input.length()<=2)
                    {
                        return false;
                    }
                    
                }
                return true;
             }
             
             private boolean emailCheck(String str)
             {
                 int a = 0;
                 for(int i = 0;i<str.length();i++)
                 {
                    if(str.charAt(i)=='@')
                    {
                        a = i;
                    }
                    if(str.charAt(i)=='.')
                    {
                        if(i<a)
                        {
                            return false;
                        }
                    }
                }
                return true;
             }
             
             
             private boolean isNumericZip(String str)
             {
                 
                 
                 if(str.length() < 3 || str.length() > 5)
                 {
                     return false;
                    }
                 
                 
                 
                 
                 int c = 0;
                for(int i = 0; i<str.length(); i++)
                {
                    if(str.charAt(i)=='.')
                    {
                        c++;
                    }
                }
                
                
                String master = "1234567890";
                 for(int i = 0; i<str.length(); i++)
                 {
                     String numb = str.substring(i,i+1);
                     if(master.indexOf(numb) == -1)
                     {
                         return false;
                     }
                 }
                 
                 
                 
                 
                
                if(c>1)
                {
                    return false;
                }
                return true;
                
                
                
                
             }
             
             private boolean checkPhone(String str)
             {
                 
                 /*
                  String master = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBMN";
                 for(int i = 0; i<str.length(); i++)
                 {
                     String numb = str.substring(i,i+1);
                     if(master.indexOf(numb) == -1)
                     {
                         return false;
                     }
                 }
                 */
                 
                 for(int i = 0; i<str.length()-1;i++)
                 {
                     if(str.charAt(3) == '-' && str.charAt(7) == '-')
                     {
                         return true;
                     }else
                     {
                         return false;
                     }
                 }
                 
                 
                 
                 
                 return true;
             }
             
             
             
            public void actionPerformed(ActionEvent event)
            {
                char[] cPssword  = passwordField.getPassword();

       
            
   //    ****************************   CHANGE CODE ABOVE   AT OWN RISK           ******************************* 
                
    //*********************  Here is where the action is performed!!!!              
                
        
                String candidateName = personName.getText() ;
                String candidateEmail = emailField.getText();
                String candidateZipCode = zipCode.getText();
                String candidatebirthDate = birthDate.getText();
                String candidatePhone = phone.getText(); 
                String candidatePassWord = new String(cPssword);
                
                //change testCase
                   int testCase =2;
                
                if(testCase ==1)
                    {
                        candidateName= "Mr. M0rris1";
                        candidateEmail = "mr.morris" ;
                        candidatebirthDate= "-2";
                        candidatePassWord= candidateName;
                }
			else if(testCase ==2)
				{
				candidateName= "M";
                        candidateEmail = "mr.mo@rris" ;
                        candidatebirthDate= "1500";
                        candidatePassWord= "a";
                }
                    
                if(testCase > -1)      
                    {
                     personName.setText(candidateName );
                    emailField.setText(candidateEmail);
                    birthDate.setText(candidatebirthDate) ;
                    zipCode.setText(candidateZipCode);
                    
                    
                    }
                
                
                try{
                     int bday = Integer.parseInt(candidatebirthDate);
                     
                 if(bday < 1820)
                 {
                    textArea.append("\nwrong age");
                 }else
                 {
                    textArea.append("\ncorrect age");
                    }
              
                
                }catch(java.lang.NumberFormatException e)
                {
                    textArea.append("\nYou must enter a number.");
                }
                

                
                if(candidateName.equals(candidatePassWord))
                {
                    textArea.setText("\nYour Username and Password must be different");
                }
                
                if(isAllAlpha(candidateName) == true)
                {
                    textArea.append("\ncorrect");
                }else if(isAllAlpha(candidateName) == false)
                {
                    textArea.append("\nfalse you need to fix your username");
                }
                  
                
                
                 if(checkPhone(candidatePhone) == true)
                {
                    textArea.append("\ncorrect phone");
                }else if(checkPhone(candidatePhone) == false)
                {
                    textArea.append("\nfalse you need to fix your phone#");
                }
                
                
                
                
                if(isNumericZip(candidateZipCode) ==true)
                {
                    textArea.append("\nValid");
                }else if(isNumericZip(candidateZipCode)==false)
                {
                    textArea.append("\nYour Format for zip code is wrong");
                }
                
                 
                if(emailCheck(candidateEmail) == true)
                {
                    textArea.append("");
                }else if(emailCheck(candidateEmail) == false)
                {
                    textArea.append("\nincorrect email");
                }
                
            
                
               
                
               
              //
//********************************************************************************
   //    ****************************       CHANGE CODE BELOW AT OWN RISK    ******************************* 
               
            
            }
            
         });

      add(southPanel, BorderLayout.SOUTH);

      // add a text area with scroll bars

   }

   public static final int DEFAULT_WIDTH = 300;
   public static final int DEFAULT_HEIGHT = 300;
}