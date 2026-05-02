import { UserAccount } from "./UserAccount";


export class User{
    constructor(private _id:number,
        private _name:string,
        private _surname:string,
        private _city: string,
        private _mail: string,
        private _userAccount: UserAccount
    )
    {}
    get id(){ return this._id;}
    get name(){ return this._name;}
    get surname(){ return this._surname;}
    get city() { return this._city;}
    get mail() { return this._mail;}
    get userAccount() { return this._userAccount;}
}