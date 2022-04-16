/* Name: Yue Liu
 * NetID: yliu165
 * Lab Session: TR 9:40a.m.-10:55a.m.
 * TA: Sereen Assi
 * I did not collaborate with anyone on this assignment.
 */
import java.time.LocalDate;
import java.util.Date;
public class Article {
	//This is the class for HW6 Problem 1
	public String name;
	public LocalDate date;
	public LocalDate Ldate;
	public String article;
	public int likes;
	public int dislikes;
	public int likelihood;
	public Article(String a, LocalDate b){
		name = a;
		date = b;
		
	}
	public Article(String a){
		name = a;
		Ldate = LocalDate.now();
	}
	public int review(int a, int b){
		likes = a;
		dislikes = b;
		likelihood = a - b;
		return likelihood;
		
	}
	public String toString(){
		return "Name: "+name+"\nPosting Date: "+date+"\nCurrent Date: "+Ldate+"\n";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public LocalDate getLdate() {
		return Ldate;
	}
	public void setLdate(LocalDate ldate) {
		Ldate = ldate;
	}
	public String getArticle() {
		return article;
	}
	public void setArticle(String article) {
		this.article = article;
	}
	public int getLikes() {
		return likes;
	}
	public void setLikes(int likes) {
		this.likes = likes;
	}
	public int getDislikes() {
		return dislikes;
	}
	public void setDislikes(int dislikes) {
		this.dislikes = dislikes;
	}
	public int getLikelihood() {
		return likelihood;
	}
	public void setLikelihood(int likelihood) {
		this.likelihood = likelihood;
	}
}
