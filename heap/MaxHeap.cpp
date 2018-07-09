#include <vector>
#include <iostream>

class MaxHeap{
    public:
        void insert(int v);
        void remove(int v);           
        void maxHeapify();
        void print();
	int extractMax();
	int size();
	private:
	std::vector<int> data;    
        int parent(int i);
        int leftChild(int i);
        int rightChild(int i);
		void siftUp(int i);
        void siftDown(int i);
		void swap(int e, int v);        
};

int MaxHeap::extractMax(){
    return this->data[0];
}

int MaxHeap::size(){
    return this->data.size();
}

void MaxHeap::insert(int v){
    this->data.push_back(v);
    this->siftUp(this->data.size()-1);    
}

void MaxHeap::remove(int v){
    int pos;
    for (int j = 0; j < this->data.size(); j++){
        if(this->data[j] == v){
            pos = j;
            break;
        }
    }  
    this->swap(pos,this->data.size()-1);
    this->data.pop_back();
    this->siftDown(pos);
}

void MaxHeap::swap(int e, int v){
    int temp = this->data[e];
    this->data[e] = this->data[v];
    this->data[v] = temp;
}

void MaxHeap::siftUp(int i){
    int temp;
    while (i > 0 && this->data[this->parent(i)] < this->data[i]){        
        temp = this->data[i];
        this->swap(i, this->parent(i));
        i = this->parent(i);       
    }    
}

void MaxHeap::siftDown(int i){
    int maxIndex = i;
    int l = this->leftChild(i);
    int r = this->rightChild(i);
    if (l < this->data.size() && this->data[l] > this->data[maxIndex]){
        maxIndex = l;
    }    
    if (r < this->data.size() && this->data[r] > this->data[maxIndex]){
        maxIndex = r;
    }    
    if (i != maxIndex){
        this->swap(i,maxIndex);  
        this->siftDown(maxIndex);		
    }
}

void MaxHeap::maxHeapify(){    
    for (int x = 0; x < this->data.size() ; x++){
        this->siftDown(x);
    }
}

int MaxHeap::parent(int i){
    return (i-1)/2;
}

int MaxHeap::leftChild(int i){
    return 2*i + 1;
}

int MaxHeap::rightChild(int i){
    return 2*i + 2;
}

void MaxHeap::print(){
    if(this->data.size() > 0){
        std::cout << "[";
        for (int x = 0; x < this->data.size()-1; x++){
            std::cout << this->data[x] << ", ";
        }
        std::cout << this->data[this->data.size()-1] << "]" << "\n";
    }
    else{
       std::cout << "Heap is empty.\n"; 
    }
}
