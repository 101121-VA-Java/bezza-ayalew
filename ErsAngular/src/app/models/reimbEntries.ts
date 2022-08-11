import { Timestamp } from "rxjs";

export interface ReimbEntries {
  isSelected: boolean,
  reimbId: number,
  reimbAmount: number,
  reimbDescription: string,
  reimbReceipt: string,
  reimbResolved: Date,
  reimbSubmitted: Date,
  reimbAuthor: number,
  reimbResolver: number,
  reimbStatus: number,
  reimbType: number,
  isEdit: boolean,
  
 }

 export const ReimbColumns = [
  {
    key: 'isSelected',
    type: 'isSelected',
    label: ''
  },
  {
    key: 'reimbAmount',
    type: 'number',
    label: 'Amount'
  },
  {
    key: 'reimbDescription',
    type: 'text',
    label: 'Desciption'
  },
  {
    key: 'reimbReceipt',
    type: 'text',
    label: 'Receipt'
  },
  {
    key: 'reimbResolved',
    type: 'date',
    label: 'Date Resolved'
  },
  {
    key: 'reimbSubmitted',
    type: 'date',
    label: 'Date Submitted'
  },
  {
    key: 'reimbAuthor',
    type: 'number',
    label: 'Resolver'
  },
  {
    key: 'reimbStatus',
    type: 'number',
    label: 'Status'
  },
  {
    key: 'reimbType',
    type: 'number',
    label: 'Type'
  },
  {
    key: 'isEdit',
    type: 'isEdit',
    label: ''
  }
]
