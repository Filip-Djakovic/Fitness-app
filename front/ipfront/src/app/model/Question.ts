import { Programm } from "./Programm";
import { User } from "./User";

export class Question{
    constructor(private _id: number,
                private _text: string,
                private _response: string,
                private _programm: Programm,
                private _user: User
    ){}

    get id(){return this._id}
    get text(){return this._text}
    get response(){return this._response}
    get programm(){return this._programm}
    get user(){return this._user}

    set response(value: string) {
        this._response = value;
    }
}