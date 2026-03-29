class TrieNode {
  constructor() {
    this.children = {};
    this.endPoint = false;
  }

  addWord(word) {
    let curr = this;

    for (const ch of word.split('')) {
      if (!Object.hasOwn(curr.children, ch)) {
        curr.children[ch] = new TrieNode();
      }
      curr = curr.children[ch];
    }

    curr.endPoint = true;
  }
}

class Solution {
  /**
   * @param {character[][]} board
   * @param {string[]} words
   * @return {string[]}
   */
  findWords(board, words) {
    let root = new TrieNode();
    for (const word of words) {
      root.addWord(word);
    }

    const row = board.length,
      col = board[0].length;
    const res = new Set(),
      visit = new Set();

    function dfs(r, c, node, word) {
      // Boundary checks and visit check
      if (
        r < 0 || r >= row ||  // FIX 1: Changed r===row to r>=row
        c < 0 || c >= col ||  // FIX 2: Changed c===col to c>=col
        visit.has(`${r}-${c}`) ||
        !Object.hasOwn(node.children, board[r][c])
      )
        return;
      
      visit.add(`${r}-${c}`);
      const nextNode = node.children[board[r][c]];  // FIX 3: Use local variable instead of modifying root
      word += board[r][c];
      
      if (nextNode.endPoint) {  // FIX 4: Check nextNode instead of node
        res.add(word);
      }

      // FIX 5: Pass nextNode to recursive calls
      dfs(r - 1, c, nextNode, word);
      dfs(r + 1, c, nextNode, word);
      dfs(r, c - 1, nextNode, word);
      dfs(r, c + 1, nextNode, word);
      
      visit.delete(`${r}-${c}`);
    }

    for (let r = 0; r < row; r++) {
      for (let c = 0; c < col; c++) {
        dfs(r, c, root, "");
      }
    }

    return [...res];
  }
}