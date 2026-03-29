class TimeMap {
  constructor() {
    this.keyStore = new Map();
  }

  /**
   * @param {string} key
   * @param {string} value
   * @param {number} timestamp
   * @return {void}
   */
  set(key, value, timestamp) {
    if (this.keyStore.has(key)) {
      const keyStoreList = this.keyStore.get(key).concat({ timestamp, value });
      this.keyStore.set(key, keyStoreList);
      return;
    }
    this.keyStore.set(key, [{ timestamp, value }]);
  }

  /**
   * @param {string} key
   * @param {number} timestamp
   * @return {string}
   */
  get(key, timestamp) {
    const timeList = this.keyStore.get(key) || [];
    for(let i = timeList.length - 1;i >= 0;i--){
      if(timeList[i]?.timestamp <= timestamp){
        return timeList[i]?.value;
      }
    }
    return '';
  }
}
