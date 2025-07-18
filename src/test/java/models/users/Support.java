package models.users;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Support{
	private String text;
	private String url;

	public void setText(String text){
		this.text = text;
	}

	public String getText(){
		return text;
	}

	public void setUrl(String url){
		this.url = url;
	}

	public String getUrl(){
		return url;
	}
}
