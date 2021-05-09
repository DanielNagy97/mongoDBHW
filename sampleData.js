db.albums.insertMany([
    {
        "_id": 0,
        "title": "East-West",
        "artist": 0,
        "year": 1966,
        "genre": "Blues",
        "price": 15
    },
    {
        "_id": 1,
        "title": "L.A. Woman",
        "artist": 1,
        "year": 1971,
        "genre": "Rock",
        "price": 20
    },
    {
        "_id": 2,
        "title": "Vol. 4",
        "artist": 2,
        "year": 1972,
        "genre": "Rock",
        "price": 23
    },
    {
        "_id": 3,
        "title": "Sabotage",
        "artist": 2,
        "year": 1975,
        "genre": "Rock",
        "price": 18
    },
    {
        "_id": 4,
        "title": "In-A-Gadda-Da-Vida",
        "artist": 3,
        "year": 1968,
        "genre": "Rock",
        "price": 21
    },
    {
        "_id": 5,
        "title": "The Number Of The Beast",
        "artist": 4,
        "year": 1982,
        "genre": "Rock",
        "price": 21
    },
    {
        "_id": 6,
        "title": "Funky Stuff",
        "artist": 5,
        "year": 1975,
        "genre": "Jazz",
        "price": 22
    }
]
)

db.artists.insertMany(
    [
        {
            "_id": 0,
            "name": "The Butterfield Blues Band",
            "country": "USA"
        },
        {
            "_id": 1,
            "name": "The Doors",
            "country": "USA"
        },
        {
            "_id": 2,
            "name": "Black Sabbath",
            "country": "UK"
        },
        {
            "_id": 3,
            "name": "Iron Butterfly",
            "country": "USA"
        },
        {
            "_id": 4,
            "name": "Iron Maiden",
            "country": "UK"
        },
        {
            "_id": 5,
            "name": "Soul Media",
            "country": "Japan"
        }
    ]
)

db.customers.insert({
    "_id": 1,
    "name": "Próba Ágnes",
    "email": "proba@agnes.hu",
    "purchases": []
})
