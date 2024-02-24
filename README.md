### Oprah's Rook Club Backend ##


There are two sets of endpoints:

- Entrants:

    GET `/entrants`

    GET `/entrants/clear`

    POST `/entrants`
    - Body:
    ```
    {
        firstName: string
        lastName: string
        displayName: string
        email: string
    }
    ```


- Pairing

    GET `/pairings`: Returns active pairings

    GET `/pairings/clear`

    GET `/pairings/create`