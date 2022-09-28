import { Timestamp } from "rxjs";

export interface ReimbEntries {
  isSelected: boolean,
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
  isEdit: boolean,
  
 }

 export const ReviewReimbColumns = [
  {
    key: 'isSelected',
    type: 'isSelected',
    label: ''
  },
  {
    key: 'reimbId',
    type: 'number',
    label: 'Claim Id',
    disabled: true
  },
  {
    key: 'reimbAuthor',
    type: 'number',
    label: 'Employee Id',
    disabled: true
  },
  {
    key: 'reimbAmount',
    type: 'number',
    step: 'any',
    label: 'Amount'
  },
  {
    key: 'reimbDescription',
    type: 'text',
    label: 'Desciption'
  },
  {
    key: 'reimbType',
    type: 'number',
    label: 'Type'
  },
  {
    key: 'reimbReceipt',
    type: 'text',
    label: 'Receipt'
  },
  {
    key: 'reimbSubmitted',
    type: 'date',
    label: 'Date Submitted',
    disabled: true
  },
  {
    key: 'reimbStatus',
    type: 'number',
    label: 'Status'
  },
  {
    key: 'reimbResolved',
    type: 'date',
    label: 'Date Resolved',
    disabled: true
  },
  {
    key: 'reimbResolver',
    type: 'number',
    label: 'Resolver Id',
    disabled: true
  },
  {
    key: 'isEdit',
    type: 'isEdit',
    label: ''
  }
]

 export const ReimbColumns = [
  {
    key: 'isSelected',
    type: 'isSelected',
    label: ''
  },
  {
    key: 'reimbId',
    type: 'number',
    label: 'Claim Id'
  },
  {
    key: 'reimbAuthor',
    type: 'number',
    label: 'Employee Id'
  },
  {
    key: 'reimbAmount',
    type: 'number',
    step: 'any',
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
