export class RssFeedItem{
    constructor(private _title:string,
        private _link:string,
        private _description:string,
        private _category: string) {}
    
    
    get title() { return this._title}
    get link() { return this._link}
    get description() { return this._description}
    get category() { return this._category}
    
}