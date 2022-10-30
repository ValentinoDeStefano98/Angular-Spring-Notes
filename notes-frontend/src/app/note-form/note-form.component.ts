import { Component, OnInit } from '@angular/core';
import { NoteService } from '../note.service';
import { Note } from '../note';
import { User } from '../user';
import { LoginService } from '../login.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-note-form',
  templateUrl: './note-form.component.html',
  styleUrls: ['./note-form.component.css']
})
export class NoteFormComponent implements OnInit {

  note: Note;
  user!: User;

 

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private noteService: NoteService,
    private loginService: LoginService
  ) {
    this.note = new Note();

   }

  ngOnInit(): void {
  }

  onSubmit(){
    this.noteService.save(this.note).subscribe({ next: (result) => this.goToNoteList()});
  }

  goToNoteList(){
    this.router.navigate(['/home/:id']);
  }

}
