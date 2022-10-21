import { ReimbEntries, ReimbColumns, ReviewReimbColumns } from './../../models/reimbEntries';
import { EmployeeColumns } from './../../models/employee';
import { DataService } from 'src/app/services/data.service';
import { Component, OnInit, ViewChild, } from '@angular/core';
import { Employee } from 'src/app/models/employee';
import { EmployeeService } from 'src/app/services/employee.service';
import { MatTableDataSource } from '@angular/material/table';
import { MatPaginator } from '@angular/material/paginator';


@Component({
  selector: 'app-manager',
  templateUrl: './manager.component.html',
  styleUrls: ['./manager.component.css'],
})
export class ManagerComponent implements OnInit {
  displayedColumns: string[] = [];
  columnsSchema: any = [];

  employeeDataSource = new MatTableDataSource<Employee>();
  reimbDataSource = new MatTableDataSource<ReimbEntries>();
  valid: any = {};

  statusDescription = [
    { id: 1, name: 'pending' },
    { id: 2, name: 'approved' },
    { id: 3, name: 'rejected' },
    { id: 4, name: 'all' }
  ];

  selectedStatus = '';
  selectedReimbs = false;
  reimbByAuthor = false;
  allEmployees = false;
  employeeById = false;
  reimbById = false;
  employees: any = [];
  reimbursements: any = [];

  @ViewChild(MatPaginator)
  paginator!: MatPaginator;
  
  constructor(private es: EmployeeService, private ds: DataService) {}

  ngAfterViewInit(): void {
    this.reimbDataSource.paginator = this.paginator;
  }

  ngOnInit(): void {
    this.es.getUsers().subscribe((res:any) => 
    this.employees = res);
    this.ds.getReimbursements().subscribe((res: any) =>
    this.reimbursements = res);
  }

  onEmpId(event: any){
    let emp: any = [];
    console.log(event.target.value);
    for (const employee of this.employees) {
      if(employee.ersUserId == event.target.value){
        emp.push(employee);
      }
    }
    this.employeeDataSource.data = emp;
    this.columnsSchema = EmployeeColumns;
    this.displayedColumns = EmployeeColumns.map((col) => col.key);
    this.employeeById = true;
    this.selectedReimbs = false;
    this.reimbByAuthor = false;
    this.allEmployees = false;
  }

  onReimbByAuthId(event: any) {
    let reimb: any = [];
    console.log(event.target.value);
    for (const reimbursement of this.reimbursements) {
      if(reimbursement.reimbAuthor == event.target.value){
        reimb.push(reimbursement);
      }
    }
    this.reimbDataSource = reimb;
    this.columnsSchema = ReviewReimbColumns;
    this.displayedColumns = ReviewReimbColumns.map((col) => col.key);
    this.reimbByAuthor = true;
    this.selectedReimbs = false;
    this.allEmployees = false;
    this.employeeById = false;
  }

  getAllEmployees() {
    this.employeeDataSource.data = this.employees;
    this.columnsSchema = EmployeeColumns;
    this.displayedColumns = EmployeeColumns.map((col) => col.key);
    this.allEmployees = true;
    this.selectedReimbs = false;
    this.reimbByAuthor = false;
    this.employeeById = false; 
  }

  getReimbsByStatus(status: String) {
    this.columnsSchema = ReviewReimbColumns;
    this.displayedColumns = ReviewReimbColumns.map((col) => col.key);
    this.reimbByAuthor = false;
    this.employeeById = false;
    this.selectedReimbs = true;
    if(status === "all"){
      this.reimbDataSource.data = this.reimbursements;
    }else{
      this.ds.getReimbursementsByStatus(status)
      .subscribe((res: any) => this.reimbDataSource.data = res);
    }
  }

  editReimbRow(row: ReimbEntries){
    row.reimbResolved = new Date().toISOString().substring(0,10);
    console.log(this.es.token.split(":")[0]);
    row.reimbResolver = Number.parseInt(this.es.token.split(":")[0]);
    this.ds.updateReimbursement(row).subscribe(() => (row.isEdit = false));
  }

  submitReimbRow(row: ReimbEntries){
    this.ds.addReimbursement(row).subscribe(() => (row.isEdit = false));
  }

  inputHandler(e: any, id: number, key: string) {
    if (!this.valid[id]) {
      this.valid[id] = {};
    }
    this.valid[id][key] = e.target.validity.valid;
  }

  disableSubmit(id: number) {
    if (this.valid[id]) {
      return Object.values(this.valid[id]).some((item) => item === false);
    }
    return false;
  }
}
