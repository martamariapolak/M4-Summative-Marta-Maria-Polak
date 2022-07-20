import { useState, useEffect } from "react";
import "./Games.css";
import GamesCard from "./GamesCard.js";
import GamesForm from "./GamesForm";

function Games() {
  const [games, setGames] = useState([]);
  const [showForm, setShowForm] = useState(false);
  const [scopedGame, setScopedGame] = useState({});
  const [error, setError] = useState();

  useEffect(() => {
    fetch("http://localhost:8080/games")
      .then((response) => response.json())
      .then((result) => setGames(result))
      .catch(console.log);
  }, []);

  function addClick() {
    const now = new Date();
    setScopedGame({
      id: 0,
      title: "",
      ESRBRating: "",
      description: "",
      price: "",
      studio: "",
      quantity: "",
    });
    setShowForm(true);
  }

  function notify({ action, games, error }) {
    if (error) {
      setError(error);
      setShowForm(false);
      return;
    }

    switch (action) {
      case "add":
        setGames([...games, games]);
        break;
      case "edit":
        setGames(
          games.map((e) => {
            if (e.id === games.id) {
              return games;
            }
            return e;
          })
        );
        break;
      case "edit-form":
        setScopedGame(games);
        setShowForm(true);
        return;
      case "delete":
        setGames(games.filter((e) => e.id !== games.id));
        break;
    }

    setError("");
    setShowForm(false);
  }

  if (showForm) {
    return <GamesForm games={scopedGame} notify={notify} />;
  }

  return (
    <>
      {error && <div className="alert alert-danger">{error}</div>}
      <div>
        <h1 id="gamesTitle">Games</h1>
        <button className="btn btn-primary" type="button" onClick={addClick}>
          Add a Game
        </button>
        <table id="games">
          <tr>
            <th>Title</th>
            <th>ESRBRating </th>
            <th>description</th>
            <th>price</th>
            <th>studio</th>
            <th>quantity</th>
          </tr>
          <tbody>
            {games.map((r) => (
              <GamesCard key={r.id} games={r} notify={notify} />
            ))}
          </tbody>
        </table>
      </div>
    </>
  );
}

export default Games;
