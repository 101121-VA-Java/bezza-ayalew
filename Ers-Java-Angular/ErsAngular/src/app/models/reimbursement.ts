import { Timestamp } from "rxjs";

export interface Reimbursement {
  reimbId: number,
  reimbAmount: number,
  reimbDescription: string,
  reimbReceipt: string,
  reimbResolved: string,
  reimbSubmitted: string,
  reimbAuthor: number,
  reimbResolver: number,
  reimbStatus: number,
  reimbType: number,
  isEdit: true,
  isSelected: false
 }

 export const ReimbursementColumns = [
  {
    key: 'isSelected',
    type: 'isSelected',
    label: '',
  },
  {
    key: 'reimbId',
    type: 'number',
    label: 'Id',
  },
  {
    key: 'reimbAmount',
    type: 'number',
    label: 'Amount',
  },
  {
    key: 'reimbDescription',
    type: 'text',
    label: 'Desciption',
  },
  {
    key: 'reimbReceipt',
    type: 'text',
    label: 'Receipt',
  },
  {
    key: 'reimbResolved',
    type: 'date',
    label: 'Date Resolved',
  },
  {
    key: 'reimbSubmitted',
    type: 'date',
    label: 'Date Submitted',
  },
  {
    key: 'reimbAuthor',
    type: 'number',
    label: 'Resolver',
  },
  {
    key: 'reimbStatus',
    type: 'number',
    label: 'Status',
  },
  {
    key: 'reimbType',
    type: 'number',
    label: 'Type',
  },
  {
    key: 'isEdit',
    type: 'isEdit',
    label: '',
  }
]
