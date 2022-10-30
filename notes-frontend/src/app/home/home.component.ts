import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Note } from '../note';
import { NoteService } from '../note.service';
import { User } from '../user';
import { LoginService } from '../login.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  
  notes!: Note[];
  user!: User;
  isProfile!: boolean;

  constructor(private noteService: NoteService, private route: ActivatedRoute, private loginService: LoginService) { 
  }

  ngOnInit(): void {
    this.noteService.findAll().subscribe(data=> {
      this.notes = data
    });
  }

}
