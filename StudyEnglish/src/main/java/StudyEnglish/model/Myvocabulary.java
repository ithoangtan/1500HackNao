package StudyEnglish.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="myvocabulary")
public class Myvocabulary implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idmyvocabulary;
	private String image;
	private String voca;
	private String spelling;
	private int idtypeword;
	private String meaning;
	private String example1;
	private String example2;
	private int idunit;
	private int idpart1;
	private String contentsoundsame;
	private int idusers;
	public Myvocabulary( String image, String voca, String spelling, int idtypeword, String meaning,
			String example1, String example2, int idunit, int idpart1, String contentsoundsame, int idusers) {
		super();
		this.image = image;
		this.voca = voca;
		this.spelling = spelling;
		this.idtypeword = idtypeword;
		this.meaning = meaning;
		this.example1 = example1;
		this.example2 = example2;
		this.idunit = idunit;
		this.idpart1 = idpart1;
		this.contentsoundsame = contentsoundsame;
		this.idusers = idusers;
	}
	@Override
	public String toString() {
		return "Myvocabulary [idmyvocabulary=" + idmyvocabulary + ", image=" + image + ", voca=" + voca + ", spelling="
				+ spelling + ", idtypeword=" + idtypeword + ", meaning=" + meaning + ", example1=" + example1
				+ ", example2=" + example2 + ", idunit=" + idunit + ", idpart1=" + idpart1 + ", contentsoundsame="
				+ contentsoundsame + ", idusers=" + idusers + "]";
	}
	public Myvocabulary() {
		
	}
	
	public int getIdmyvocabulary() {
		return idmyvocabulary;
	}
	public void setIdmyvocabulary(int idmyvocabulary) {
		this.idmyvocabulary = idmyvocabulary;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getVoca() {
		return voca;
	}
	public void setVoca(String voca) {
		this.voca = voca;
	}
	public String getSpelling() {
		return spelling;
	}
	public void setSpelling(String spelling) {
		this.spelling = spelling;
	}
	public int getIdtypeword() {
		return idtypeword;
	}
	public void setIdtypeword(int idtypeword) {
		this.idtypeword = idtypeword;
	}
	public String getMeaning() {
		return meaning;
	}
	public void setMeaning(String meaning) {
		this.meaning = meaning;
	}
	public String getExample1() {
		return example1;
	}
	public void setExample1(String example1) {
		this.example1 = example1;
	}
	public String getExample2() {
		return example2;
	}
	public void setExample2(String example2) {
		this.example2 = example2;
	}
	public int getIdunit() {
		return idunit;
	}
	public void setIdunit(int idunit) {
		this.idunit = idunit;
	}
	public int getIdpart1() {
		return idpart1;
	}
	public void setIdpart1(int idpart1) {
		this.idpart1 = idpart1;
	}
	public String getContentsoundsame() {
		return contentsoundsame;
	}
	public void setContentsoundsame(String contentsoundsame) {
		this.contentsoundsame = contentsoundsame;
	}
	public int getIdusers() {
		return idusers;
	}
	public void setIdusers(int idusers) {
		this.idusers = idusers;
	}
	

	
}

