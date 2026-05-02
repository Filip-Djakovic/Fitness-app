export class Exersise{
    constructor(private _name: string,
                private _type: string,
                private _muscle: string,
                private _equipment: string,
                private _difficulty: string,
                private _instructions: string
    )
    {}

    get name() { return this._name}
    get type() { return this._type}
    get muscle() { return this._muscle}
    get equipment() { return this._equipment}
    get difficulty() { return this._difficulty}
    get instructions() { return this._instructions}
}