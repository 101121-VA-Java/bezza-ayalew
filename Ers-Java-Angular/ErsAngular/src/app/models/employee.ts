export interface Employee {
    isSelected: boolean;
    ersUserId: number;
    ersPassword: string;
    ersUsername: string;
    userEmail: string;
    userFirstName: string;
    userLastName: string;
    userRoleId: number;
    isEdit: boolean;
}

export const EmployeeColumns = [
    {
      key: 'isSelected',
      type: 'isSelected',
      label: ''
    },
    {
        key: 'ersPassword',
        type: 'text',
        label: 'Password',
        requrired: true
    },
    {
      key: 'ersUsername',
      type: 'text',
      label: 'Username',
      requrired: true
  },
    {
      key: 'userEmail',
      type: 'email',
      label: 'Email',
      requrired: true,
      pattern: '.+@.+'
    },    
    {
      key: 'userFirstName',
      type: 'text',
      label: 'First Name',
      requrired: true
    },
    {
      key: 'userLastName',
      type: 'text',
      label: 'Last Name'
    },
    {
      key: 'isEdit',
      type: 'isEdit',
      label: ''
    }
  ]