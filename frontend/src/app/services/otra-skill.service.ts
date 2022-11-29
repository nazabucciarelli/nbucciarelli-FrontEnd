import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Skill } from '../model/skill.model';

@Injectable({
  providedIn: 'root'
})
export class OtraSkillService {
  url = "http://localhost:8080/otraskill/"
  constructor(private http:HttpClient) { }
  public getAllOtraSkill(): Observable<Skill[]>{
    return this.http.get<Skill[]>(this.url + "traer");
  }

  public getOtraSkillById(id:number): Observable<Skill>{
    return this.http.get<Skill>(this.url + "traer/" + id);
  }

  public deleteOtraSkillById(id:number):Observable<any>{
    return this.http.delete<any>(this.url + "borrar/" + id);
  }

  public addOtraSkill(otraSkill: Skill): Observable<any>{
    return this.http.post<any>(this.url + "agregar",otraSkill);
  }

  public editOtraSkill(id:number,otraSkill:Skill): Observable<any>{
    return this.http.put<any>(this.url + "editar/" + id,otraSkill);
  }
}