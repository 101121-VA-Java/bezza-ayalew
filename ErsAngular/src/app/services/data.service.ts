import { ReimbEntries } from './../models/reimbEntries';
import { Reimbursement } from 'src/app/models/reimbursement';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map, Observable } from 'rxjs';
import { Employee } from '../models/employee';

@Injectable({
  providedIn: 'root'
})
export class DataService {
  private reimbUrl = 'http://localhost:8081/reimbursement';

  constructor(private http: HttpClient) { }

  getReimbursements(): any{
    return this.http.get(`${this.reimbUrl}`).pipe(map((res: any) => res));
  }
  getReimbursementsByStatus(status: String): any{
    return this.http.get(`${this.reimbUrl}?status=${status}`).pipe(map((res: any) => res));
  }

  getReimbursementByAuthorId(authId: number): any{
    return this.http.get(`${this.reimbUrl}?authId=${authId}`).pipe(map((res: any) => res));
  }
  getReimbursementById(id: number): any{
    return this.http.get(`${this.reimbUrl}/id`).pipe(map((res: any) => res));
  }
  addReimbursement(reimb: Reimbursement): Observable<ReimbEntries> {
      return this.http.put<ReimbEntries>(`${this.reimbUrl}`, reimb
      );
  }
  updateReimbursement(reimb: ReimbEntries): Observable<ReimbEntries> {
    return this.http.patch<ReimbEntries>(`${this.reimbUrl}`, reimb
    );
  }
}
