import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { Router, RouterEvent, ActivatedRoute } from '@angular/router';
import { LoginService } from '../login.service';
import { User } from '../user';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  @ViewChild('buttonLogin') input!: ElementRef<HTMLInputElement>;

  user:User = new User();

  constructor(private loginService: LoginService, private router: Router, private route: ActivatedRoute) {
    
  }

  ngOnInit(): void {
  }

  userLogin() {
    console.log(this.user.name)
    this.loginService.loginUser(this.user)
    .subscribe({ 
      next: (data) =>{     
      this.router.navigate(['welcome']);
      console.log(data);
    }, 
    error: (e) => alert("Credenziali errate o utente non registrato")
  });
}

}

