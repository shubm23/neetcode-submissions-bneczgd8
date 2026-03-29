class TrieNode {
  constructor() {
    this.children = {};
    this.endPoint = false;
  }
}

class WordDictionary {
  constructor() {
    this.root = new TrieNode();
  }

  /**
   * @param {string} word
   * @return {void}
   */
  addWord(word) {
    let curr = this.root;

    for (const ch of word.split('')) {
      if (!Object.hasOwn(curr?.children || {}, ch)) {
        curr.children[ch] = new TrieNode();
      }
      curr = curr.children[ch];
    }

    curr.endPoint = true;
  }

  /**
   * @param {string} word
   * @return {boolean}
   */
  search(word) {
    function dfs(j, root) {
      let curr = root;
      for (let i = j; i < word.length; i++) {
        const ch = word.charAt(i);
        if (ch === '.') {
          for (const child of Object.values(curr.children)) {
            if (dfs(i + 1, child)) return true;
          }
          return false;
        } else {
          if(!Object.hasOwn(curr?.children || {},ch)) return false;
          curr = curr.children[ch];
        }
      }
      return curr.endPoint;
    }
    
    return dfs(0,this.root);
  }
}
