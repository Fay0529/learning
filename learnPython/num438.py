# -*- coding: utf-8 -*-
"""
Created on Thu Oct 25 20:42:56 2018

@author: Fay
"""

class Solution(object):
    def findAnagrams(self, s, p):
        """
        :type s: str
        :type p: str
        :rtype: List[int]
        """
        slen = len(s)
        plen = len(p)
        if plen > slen:
            return []
        alphabet = [chr(i) for i in range(97,123)]
        sdict = dict.fromkeys(alphabet,0)
        pdict = dict.fromkeys(alphabet,0)
        res = []
        for x in p :
            pdict[x] = pdict.get(x,0)+1
        for i in range(plen):
            sdict[s[i]] = sdict.get(s[i],0)+1
        if sdict == pdict:
            res.append(0)
        for i in range(1,slen - plen + 1):
            sdict[s[i-1]] = sdict[s[i-1]] - 1
            sdict[s[i + plen- 1]] = sdict.get(s[i+plen-1],0)+1
            if sdict == pdict :
                res.append(i)
        return res