class TrieNode {
  constructor() {
    this.children = {};
    this.endPoint = false;
  }
}

class PrefixTree {
  constructor() {
    this.root = new TrieNode();
  }

  /**
   * @param {string} word
   * @return {void}
   */
  insert(word) {
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
    let curr = this.root;
    for (const ch of word.split('')) {
      if (!Object.hasOwn(curr.children, ch)) return false;
      curr = curr.children[ch];
    }
    return curr.endPoint;
  }

  /**
   * @param {string} prefix
   * @return {boolean}
   */
  startsWith(prefix) {
    let curr = this.root;
    for (const ch of prefix.split('')) {
      if (!Object.hasOwn(curr.children, ch)) return false;
      curr = curr.children[ch];
    }
    return true;
  }
}