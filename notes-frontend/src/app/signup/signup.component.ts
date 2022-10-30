import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { SignupService } from '../signup.service';
import { User } from '../user';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  user: User = new User();

  constructor(private signupService: SignupService, private router: Router) { }

  ngOnInit(): void {
  }

  userRegister(){
    console.log(this.user);
    this.signupService.registerUser(this.user).subscribe(data=>{
      this.loginPage()
      alert("Registrazione effettuata, ora accedi")
    }, error => alert("Operazione non andata a buon fine, riprova"));
  }

  loginPage(){
    this.router.navigate(['/login']);
  }

}
