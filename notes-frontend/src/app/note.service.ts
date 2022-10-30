import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Note } from './note';

@Injectable({
  providedIn: 'root'
})
export class NoteService {

  note!: Note[];

  private baseUrl: string;

  constructor(private http: HttpClient) {
    this.baseUrl = 'http://localhost:8080/notes';
  }

  public findAll(): Observable<Note[]>{
    return this.http.get<Note[]>(this.baseUrl);
  }

  public save(note: Note){
    return this.http.post<Note>(this.baseUrl, note);
  }

  getAll(): Observable<Note[]> {
    return this.http.get<Note[]>(this.baseUrl);
  }

  get(id: any): Observable<Note> {
    return this.http.get<Note>(`${this.baseUrl}/${id}`);
  }

  delete(id : any): Observable<any> {
    return this.http.delete<any>(`${this.baseUrl}/${id}`);
  }

  deleteAll(): Observable<any> {
    return this.http.delete(this.baseUrl);
  }
  
}
