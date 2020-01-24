import { User } from './user';

export interface Business {
    id: number;
    name: string;
    email: string;
    address: string;
    users: Array<User>;
}
