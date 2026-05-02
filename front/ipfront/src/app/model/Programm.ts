import { Category } from "./Category";
import { Instructor } from "./Instructor";
import { User } from "./User";
import { Location } from "./Location";
export class Programm{
    constructor(private _id: number,
                private _price: number,
                private _level: number,
                private _time: number,
                private _name: string,
                private _description: string,
                private _picture: any,
                private _contact: string,
                private _isParticipated: number,
                private _isActivated: number,
                private _isFinished: number,
                private _category: Category,
                private _location: Location,
                private _instructor: Instructor,
                private _user: User){}

                get id() { return this._id; }
                get price() { return this._price; }
                get level() { return this._level; }
                get time() { return this._time; }
                get name() { return this._name; }
                get description() { return this._description; }
                get picture() { return this._picture; }
                get contact() { return this._contact; }
                get isParticipated() { return this._isParticipated; }
                get isActivated() { return this._isActivated; }
                get isFinished() { return this._isFinished; }
                get category() { return this._category; }
                get location() { return this._location; }
                get instructor() { return this._instructor; }
                get user() { return this._user; }
}