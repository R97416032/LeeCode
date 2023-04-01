/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        ListNode *ans,*q=new ListNode();
        ans=q;
        int c=0;
        while(l1!=nullptr&&l2!=nullptr){
            ListNode *p=new ListNode();
            p->val=(l1->val+l2->val+c)%10;
            c=(l1->val+l2->val+c)/10;
            l1=l1->next;
            l2=l2->next;
            q->next=p;
            q=q->next;
        }
        while(l1!=nullptr){
            ListNode *p=new ListNode();;
            p->val=(l1->val+c)%10;
            c=(l1->val+c)/10;
            l1=l1->next;
            q->next=p;
            q=q->next;
        }
        while(l2!=nullptr){
            ListNode *p=new ListNode();
            p->val=(l2->val+c)%10;
            c=(l2->val+c)/10;
            l2=l2->next;
            q->next=p;
            q=q->next;
        }
        if(c!=0){
            ListNode *p=new ListNode(c);
            q->next=p;
        }
            
        return ans->next;
    }
};