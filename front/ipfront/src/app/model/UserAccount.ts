export class UserAccount{
    constructor(private _username:string,
                private _password:string,
                private _isActivated: number
    )
    {}
    get username(){
        return this._username;
    }
    get password(){
        return this._password;
    }

    get isActivated(){
        return this._isActivated;
    }
}