package StudyEnglish.model;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

public class TalkResource {
	 private static final String VOICENAME_kevin = "kevin16";

	    public TalkResource(String sayText) {
	    	System.setProperty("freetts.voices", "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");
	        Voice voice;
	        VoiceManager voiceManager = VoiceManager.getInstance();
	        voice = voiceManager.getVoice(VOICENAME_kevin);
	        voice.allocate();

	        voice.speak(sayText);
	    }

}