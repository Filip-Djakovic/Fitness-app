export class Category{
    constructor(private _id: number,
                private _name: string,
                private _attributes: string
    ){}

    get id() {return this._id}
    get name() {return this._name}
    get attributes() {return this._attributes}
}