import { useState } from "react";

function GamesForm({ games: initialGames, notify }) {
  const [games, setGames] = useState(initialGames);
  const isAdd = initialGames.id === 0;

  function handleChange(evt) {
    const clone = { ...games };
    clone[evt.target.name] = evt.target.value;
    setGames(clone);
  }

  function handleSubmit(evt) {
    evt.preventDefault();

    const url = isAdd
      ? "http://localhost:8080/games"
      : `http://localhost:8080/games/${games.id}`;
    const method = isAdd ? "POST" : "PUT";
    const expectedStatus = isAdd ? 201 : 204;

    const init = {
      method,
      headers: {
        "Content-Type": "application/json",
        Accept: "application/json",
      },
      body: JSON.stringify(games),
    };

    fetch(url, init)
      .then((response) => {
        if (response.status === expectedStatus) {
          if (isAdd) {
            return response.json();
          } else {
            return games;
          }
        }
        return Promise.reject(
          `Didn't receive expected status: ${expectedStatus}`
        );
      })
      .then((result) =>
        notify({
          action: isAdd ? "add" : "edit",
          games: result,
        })
      )
      .catch((error) => notify({ error: error }));
  }

  return (
    <>
      <h1>{games.id > 0 ? "Edit" : "Add"} Games</h1>
      <form onSubmit={handleSubmit}>
        <div className="mb-3">
          <label htmlFor="title">title</label>
          <input
            type="text"
            id="title"
            name="title"
            className="form-control"
            value={games.title}
            onChange={handleChange}
          />
        </div>
        <div className="mb-3">
          <label htmlFor="ESRBRating">ESRBRating</label>
          <input
            type="text"
            id="ESRBRating"
            name="ESRBRating"
            className="form-control"
            value={games.ESRBRating}
            onChange={handleChange}
          />
        </div>
        <div className="mb-3">
          <label htmlFor="description">description</label>
          <input
            type="text"
            id="description"
            name="description"
            className="form-control"
            value={games.description}
            onChange={handleChange}
          />
        </div>
        <div className="mb-3">
          <label htmlFor="price">price</label>
          <input
            type="text"
            id="price"
            name="price"
            className="form-control"
            value={games.price}
            onChange={handleChange}
          />
        </div>
        <div className="mb-3">
          <label htmlFor="studio">studio</label>
          <input
            type="text"
            id="studio"
            name="studio"
            className="form-control"
            value={games.studio}
            onChange={handleChange}
          />
        </div>
        <div className="mb-3">
          <label htmlFor="quantity">quantity</label>
          <input
            type="text"
            id="quantity"
            name="quantity"
            className="form-control"
            value={games.quantity}
            onChange={handleChange}
          />
        </div>
        <div className="mb-3">
          <button className="btn btn-primary mr-3" type="submit">
            Save
          </button>
          <button
            className="btn btn-secondary"
            type="button"
            onClick={() => notify({ action: "cancel" })}
          >
            Cancel
          </button>
        </div>
      </form>
    </>
  );
}

export default GamesForm;
