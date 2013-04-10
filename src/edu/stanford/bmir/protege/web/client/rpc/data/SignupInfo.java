package edu.stanford.bmir.protege.web.client.rpc.data;

import edu.stanford.bmir.protege.web.shared.user.EmailAddress;

import java.io.Serializable;

/**
 * Author: Matthew Horridge<br>
 * Stanford University<br>
 * Bio-Medical Informatics Research Group<br>
 * Date: 04/06/2012
 */
public class SignupInfo implements Serializable {

    private EmailAddress emailAddress;
    
    private String password;
    
    private String userName;
    
    private String verificationChallenge;
    
    private String verificationResponse;

    /**
     * Private constructor for serialization purposes.
     */
    private SignupInfo() {
    }

    /**
     * Creates a SignupInfo with information required for sign up and information (provided by ReCaptcha) required to
     * validate that a real human is signing up, and not a bot.
     * @param emailAddress The email address.  Must not be null.
     * @param password The password.  Must not be null.
     * @param userName The user name for the user signing up for the account. Must not be null.
     * @param verificationChallenge The verification challenge (from the ReCaptcha widget). Must not be null.
     * @param verificationResponse The verification response (from the ReCaptcha widget).  Must not be null.
     * @throws NullPointerException if any parameters are null.
     *
     */
    public SignupInfo(EmailAddress emailAddress, String userName, String password, String verificationChallenge, String verificationResponse) {
        if(emailAddress == null) {
            throw new NullPointerException("emailAddress must not be null");
        }
        if(password == null) {
            throw new NullPointerException("password must not be null");
        }
        this.emailAddress = emailAddress;
        this.userName = userName;
        this.password = password;
        this.verificationChallenge = verificationChallenge;
        this.verificationResponse = verificationResponse;
    }

    /**
     * Gets the email address.
     * @return The email address.   Not null.
     */
    public EmailAddress getEmailAddress() {
        return emailAddress;
    }

    /**
     * Gets the password.
     * @return The password.  Not null.
     */
    public String getPassword() {
        return password;
    }

    public String getUserName() {
        return userName;
    }

    /**
     * Sign up may be verified using reCaptcha. The information required for verification is a challenge and a response.
     * The challenge is generated by the reCaptcha service and the response is the text entered by the user in response
     * to the challenge.  This method gets the reCaptcha supplied challenge.
     * @return The challenge.  Not null.
     */
    public String getVerificationChallenge() {
        return verificationChallenge;
    }

    /**
     * Sign up may be verified using reCaptcha. The information required for verification is a challenge and a response.
     * The challenge is generated by the reCaptcha service and the response is the text entered by the user in response
     * to the challenge.  This method gets the response as supplied by the user.
     * @return The challenge.  Not null.
     */
    public String getVerificationResponse() {
        return verificationResponse;
    }

    @Override
    public int hashCode() {
        return emailAddress.hashCode() + password.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof SignupInfo)) {
            return false;
        }
        SignupInfo other = (SignupInfo) obj;
        return emailAddress.equals(other.emailAddress) && password.equals(other.password);
    }
}
