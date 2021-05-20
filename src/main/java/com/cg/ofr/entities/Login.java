//Note: Not Required






/*
 * package com.cg.ofr.entities;
 * 
 * import javax.persistence.CascadeType; import javax.persistence.Entity; import
 * javax.persistence.FetchType; import javax.persistence.GeneratedValue; import
 * javax.persistence.GenerationType; import javax.persistence.Id; import
 * javax.persistence.JoinColumn; import javax.persistence.OneToOne; import
 * javax.persistence.Table;
 * 
 * @Entity
 * 
 * @Table(name = "Login") public class Login {
 * 
 * @Id
 * 
 * @GeneratedValue(strategy = GenerationType.AUTO) private int loginId;
 * 
 * @OneToOne(mappedBy = "login_id",cascade = CascadeType.ALL, fetch =
 * FetchType.EAGER)
 * 
 * @JoinColumn(name = "user_id") private User user;
 * 
 * public Login() { super(); }
 * 
 * public Login(int loginId, User user) { super(); this.loginId = loginId;
 * this.user = user; }
 * 
 * public int getLoginId() { return loginId; }
 * 
 * public void setLoginId(int loginId) { this.loginId = loginId; }
 * 
 * public User getUser() { return user; }
 * 
 * public void setUser(User user) { this.user = user; }
 * 
 * }
 */